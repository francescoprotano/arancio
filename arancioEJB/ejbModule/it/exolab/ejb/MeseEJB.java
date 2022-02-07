package it.exolab.ejb;

import java.sql.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.MeseDAO;
import it.exolab.exception.CampoRichiesto;
import it.exolab.exception.Risposta;
import it.exolab.model.Mese;

@Stateless
@LocalBean
public class MeseEJB implements MeseEJBRemote {

    public MeseEJB() {
    }

	@Override
	public Risposta add(Mese mese) {
		Risposta res = new Risposta();
		try {
			MeseDAO.insert(mese);
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
	public Risposta edit(Mese mese) {
		Risposta res = new Risposta();
		try {
			MeseDAO.update(mese);
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
	public Risposta delete(Integer id_mese) {
		Risposta res = new Risposta();
		try {
			MeseDAO.delete(id_mese);
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
	public Risposta selectByMese(Date mese) {
		Risposta res = new Risposta();
		try {
			MeseDAO.selectByMese(mese);
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
	public List<Mese> allMesi() {
		return MeseDAO.selectAll();
	}

}
