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
		Risposta res = new Risposta(true);
		try {
			DipendenteDao.insert(dipendente);
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
	}

	@Override
	public Risposta edit(Dipendente dipendente) {
		Risposta res = new Risposta(true);
		try {
			DipendenteDao.update(dipendente);
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
	}

	@Override
	public Risposta delete(Integer id) {
		Risposta res = new Risposta(true);
		try {
			DipendenteDao.delete(id);
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
	}

	@Override
	public Risposta selectByEmail(String email) {
		Risposta res = new Risposta(true);
		res.setData(DipendenteDao.selectByEmail(email));
		;
		return res;
	}

	@Override
	public List<Dipendente> allDipendenti() {
		return DipendenteDao.all();
	}

	public Risposta allDipendentiRes() {
		Risposta res = new Risposta(true);
		res.setData(DipendenteDao.all());
		return res;
	}

}
