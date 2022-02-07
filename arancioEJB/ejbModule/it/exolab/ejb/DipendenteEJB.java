package it.exolab.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.DipendenteDao;
import it.exolab.exception.CampoRichiesto;
import it.exolab.exception.Risposta;
import it.exolab.model.Dipendente;

@Stateless
@LocalBean
public class DipendenteEJB implements DipendenteEJBRemote {

	public DipendenteEJB() {
	}

	@Override
	public Risposta add(Dipendente dipendente) {
		Risposta res = new Risposta();
		try {
			DipendenteDao.insert(dipendente);
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore("001"); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setErrore("errore sconosciuto");
			res.setCodice_errore("999"); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Risposta edit(Dipendente dipendente) {
		Risposta res = new Risposta();
		try {
			DipendenteDao.update(dipendente);
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore("001"); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setErrore("errore sconosciuto");
			res.setCodice_errore("999"); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Risposta delete(Integer id_dipendente) {
		Risposta res = new Risposta();
		try {
			DipendenteDao.delete(id_dipendente);
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore("001"); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setErrore("errore sconosciuto");
			res.setCodice_errore("999"); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Risposta selectByEmail(String email) {
		Risposta res = new Risposta();
		try {
			res.setData(DipendenteDao.selectByEmail(email));
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore("001"); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setErrore("errore sconosciuto");
			res.setCodice_errore("999"); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Risposta selectByRuolo(String ruolo) {
		Risposta res = new Risposta();
		try {
			res.setData(DipendenteDao.selectByRuolo(ruolo));
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore("001"); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setErrore("errore sconosciuto");
			res.setCodice_errore("999"); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Dipendente> allDipendenti() {
		return DipendenteDao.selectAll();
	}

	@Override
	public List<Dipendente> allJoinDipendentiEContratti() {
		
		return DipendenteDao.allJoinDipendentiEContratti();
	}

	@Override
	public Risposta updatePassword(Dipendente dipendente) {
		Risposta res = new Risposta();
		try {
			DipendenteDao.updatePassword(dipendente);
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore("001"); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setErrore("errore sconosciuto");
			res.setCodice_errore("999"); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}
		return res;
	}

}
