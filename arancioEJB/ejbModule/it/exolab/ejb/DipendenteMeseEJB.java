package it.exolab.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.DipendenteMeseDao;
import it.exolab.exception.CampoRichiesto;
import it.exolab.exception.ErroreGenerico;
import it.exolab.model.DipendenteMese;
import it.exolab.responces.RispostaDipendenteMese;
import it.exolab.responces.RispostaDipendentiMesi;

@Stateless
@LocalBean
public class DipendenteMeseEJB implements DipendenteMeseEJBRemote {

	public DipendenteMeseEJB() {
	}

	@Override
	public RispostaDipendenteMese update(DipendenteMese dipendenteMese) {
		RispostaDipendenteMese res = new RispostaDipendenteMese();
		try {
			DipendenteMeseDao.getIstanza().update(dipendenteMese.getId_dipendente_fk(), dipendenteMese.getId_mese_fk());
			res.setData(dipendenteMese);
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
	public RispostaDipendenteMese delete(DipendenteMese dipendenteMese) {
		RispostaDipendenteMese res = new RispostaDipendenteMese();
		try {
			DipendenteMeseDao.getIstanza().delete(dipendenteMese.getId_dipendente_fk(), dipendenteMese.getId_mese_fk());
			res.setData(dipendenteMese);
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
	public RispostaDipendenteMese selectOne(DipendenteMese dipendenteMese) {
		RispostaDipendenteMese res = new RispostaDipendenteMese();
		try {
			res.setData(DipendenteMeseDao.getIstanza().selectOne(dipendenteMese.getId_dipendente_fk(), dipendenteMese.getId_mese_fk()));
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
	public RispostaDipendentiMesi selectAll() {
		RispostaDipendentiMesi res = new RispostaDipendentiMesi();
		try {
			res.setData(DipendenteMeseDao.getIstanza().selectAll());
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
	public RispostaDipendentiMesi selectByDipendente(DipendenteMese dipendenteMese) {
		RispostaDipendentiMesi res = new RispostaDipendentiMesi();
		try {
			res.setData(DipendenteMeseDao.getIstanza().selectByDipendente(dipendenteMese.getId_dipendente_fk()));
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
		return res;	}

	@Override
	public RispostaDipendentiMesi selectByMese(DipendenteMese dipendenteMese) {
		RispostaDipendentiMesi res = new RispostaDipendentiMesi();
		try {
			res.setData(DipendenteMeseDao.getIstanza().selectByMese(dipendenteMese.getId_mese_fk()));
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
	public RispostaDipendentiMesi selectByStato(DipendenteMese dipendenteMese) {
		RispostaDipendentiMesi res = new RispostaDipendentiMesi();
		try {
			res.setData(DipendenteMeseDao.getIstanza().selectByStato(dipendenteMese.getStato()));
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

}
