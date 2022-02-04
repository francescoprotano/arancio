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
		Risposta res = new Risposta(true);
		try {
			PresenzaDao.insert(presenza);
		} catch (CampoRichiesto e) {
			res.setSuccesso(false);
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore("001");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setSuccesso(false);
			res.setErrore("errore sconosciuto");
			res.setCodice_errore("999");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Risposta edit(Presenza presenza) {
		Risposta res = new Risposta(true);
		try {
			PresenzaDao.update(presenza);
		} catch (CampoRichiesto e) {
			res.setSuccesso(false);
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore("001");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setSuccesso(false);
			res.setErrore("errore sconosciuto");
			res.setCodice_errore("999");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Risposta delete(Integer id_presenza) {
		Risposta res = new Risposta(true);
		try {
			PresenzaDao.delete(id_presenza);
		} catch (CampoRichiesto e) {
			res.setSuccesso(false);
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore("001");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setSuccesso(false);
			res.setErrore("errore sconosciuto");
			res.setCodice_errore("999");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Risposta selectByData(Date data) {
		Risposta res = new Risposta(true);
		try {
			PresenzaDao.selectByData(data);
		} catch (CampoRichiesto e) {
			res.setSuccesso(false);
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore("001");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setSuccesso(false);
			res.setErrore("errore sconosciuto");
			res.setCodice_errore("999");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Risposta selectByMese(Integer id_mese_fk) {
		Risposta res = new Risposta(true);
		try {
			PresenzaDao.selectByMese(id_mese_fk);
		} catch (CampoRichiesto e) {
			res.setSuccesso(false);
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore("001");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setSuccesso(false);
			res.setErrore("errore sconosciuto");
			res.setCodice_errore("999");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Risposta selectByDipendente(Integer id_dipendente_fk) {
		Risposta res = new Risposta(true);
		try {
			PresenzaDao.selectByDipendente(id_dipendente_fk);
		} catch (CampoRichiesto e) {
			res.setSuccesso(false);
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore("001");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setSuccesso(false);
			res.setErrore("errore sconosciuto");
			res.setCodice_errore("999");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Risposta selectByAssenza(String motivazione_assenza_fk) {
		Risposta res = new Risposta(true);
		try {
			PresenzaDao.selectByAssenza(motivazione_assenza_fk);
		} catch (CampoRichiesto e) {
			res.setSuccesso(false);
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore("001");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setSuccesso(false);
			res.setErrore("errore sconosciuto");
			res.setCodice_errore("999");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Presenza> allPresenze() {
		return PresenzaDao.selectAll();
	}

}
