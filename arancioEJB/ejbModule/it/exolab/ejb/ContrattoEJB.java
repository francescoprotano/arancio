package it.exolab.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.ContrattoDao;
import it.exolab.exception.CampoRichiesto;
import it.exolab.exception.Risposta;
import it.exolab.model.Contratto;

@Stateless
@LocalBean
public class ContrattoEJB implements ContrattoEJBRemote {

	public ContrattoEJB() {
	}

	@Override
	public Risposta add(Contratto contratto) {
		Risposta res = new Risposta();
		try {
			ContrattoDao.insert(contratto);
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
	public Risposta edit(Contratto contratto) {
		Risposta res = new Risposta();
		try {
			ContrattoDao.update(contratto);
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
	public Risposta delete(Integer id_contratto) {
		Risposta res = new Risposta();
		try {
			ContrattoDao.delete(id_contratto);
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
	public Risposta selectByID(Integer id_contratto) {
		Risposta res = new Risposta();
		try {
			ContrattoDao.selectByID(id_contratto);
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
	public Risposta selectByTipologia(String tipologia) {
		Risposta res = new Risposta();
		try {
			ContrattoDao.selectByTipologia(tipologia);
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
	public List<Contratto> allContratti() {
		return ContrattoDao.selectAll();
	}

}
