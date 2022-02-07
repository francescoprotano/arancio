package it.exolab.ejb;

import java.sql.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.PresenzaDao;
import it.exolab.exception.CampoRichiesto;
import it.exolab.exception.Risposta;
import it.exolab.model.Presenza;

@Stateless
@LocalBean
public class PresenzaEJB implements PresenzaEJBRemote {

	public PresenzaEJB() {
	}

	@Override
	public Risposta add(Presenza presenza) {
		Risposta res = new Risposta();
		try {
			PresenzaDao.insert(presenza);
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
	public Risposta edit(Presenza presenza) {
		Risposta res = new Risposta();
		try {
			PresenzaDao.update(presenza);
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
	public Risposta delete(Integer id_presenza) {
		Risposta res = new Risposta();
		try {
			PresenzaDao.delete(id_presenza);
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
	public Risposta selectByData(Date data) {
		Risposta res = new Risposta();
		try {
			PresenzaDao.selectByData(data);
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
	public Risposta selectByMese(Integer id_mese_fk) {
		Risposta res = new Risposta();
		try {
			PresenzaDao.selectByMese(id_mese_fk);
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
	public Risposta selectByDipendente(Integer id_dipendente_fk) {
		Risposta res = new Risposta();
		try {
			PresenzaDao.selectByDipendente(id_dipendente_fk);
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
	public Risposta selectByAssenza(String motivazione_assenza_fk) {
		Risposta res = new Risposta();
		try {
			PresenzaDao.selectByAssenza(motivazione_assenza_fk);
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
	public List<Presenza> selectAll() {
		return PresenzaDao.selectAll();
	}

}
