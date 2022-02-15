package it.exolab.ejb;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.MeseDAO;
import it.exolab.exception.CampoRichiesto;
import it.exolab.exception.ErroreGenerico;
import it.exolab.model.Dipendente;
import it.exolab.model.Mese;
import it.exolab.responces.RispostaMese;
import it.exolab.responces.RispostaMesi;

@Stateless
@LocalBean
public class MeseEJB extends BaseEJB implements MeseEJBRemote {

	public MeseEJB() {
	}

	@Override
	public RispostaMese add(Dipendente dipendente) {
		RispostaMese res = new RispostaMese();
		try {
			// fase di test
			Mese mese = new Mese();
			String sdata="2022-11-01";
			Date data = Date.valueOf(sdata);
			mese.setMese(data);
			//
			MeseDAO.getIstanza().insert(mese);
			res.setData(mese);
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore(BaseEJB.ERR_CODE_REQUIRED); // successo viene impostato a false dentro il
																// setCodice_errore
			e.printStackTrace();
		} catch (ErroreGenerico e) {
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il
															// setCodice_errore
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il
															// setCodice_errore
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public RispostaMese edit(Mese mese) {
		RispostaMese res = new RispostaMese();
		try {
			MeseDAO.getIstanza().update(mese);
			res.setData(mese);
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore(BaseEJB.ERR_CODE_REQUIRED); // successo viene impostato a false dentro il
																// setCodice_errore
			e.printStackTrace();
		} catch (ErroreGenerico e) {
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il
															// setCodice_errore
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il
															// setCodice_errore
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public RispostaMese delete(Mese mese) {
		RispostaMese res = new RispostaMese();
		try {
			MeseDAO.getIstanza().delete(mese);
			res.setData(mese);
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore(BaseEJB.ERR_CODE_REQUIRED); // successo viene impostato a false dentro il
																// setCodice_errore
			e.printStackTrace();
		} catch (ErroreGenerico e) {
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il
															// setCodice_errore
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il
															// setCodice_errore
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public RispostaMese selectByMese(Date mese) {
		RispostaMese res = new RispostaMese();
		try {
			res.setData(MeseDAO.getIstanza().selectByMese(mese));
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore(BaseEJB.ERR_CODE_REQUIRED); // successo viene impostato a false dentro il
																// setCodice_errore
			e.printStackTrace();
		} catch (ErroreGenerico e) {
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il
															// setCodice_errore
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il
															// setCodice_errore
			e.printStackTrace();
		}
		System.out.println(res.toString());
		return res;
	}

	@Override
	public RispostaMesi allMesi() {
		RispostaMesi res = new RispostaMesi();
		try {
			res.setData(MeseDAO.getIstanza().selectAll());
		} catch (ErroreGenerico e) {
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il
															// setCodice_errore
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il
															// setCodice_errore
			e.printStackTrace();
		}
		return res;
	}

}
