package it.exolab.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.DipendenteDao;
import it.exolab.exception.CampoRichiesto;
import it.exolab.exception.CredenzialiErrate;
import it.exolab.exception.ErroreGenerico;
import it.exolab.model.Dipendente;
import it.exolab.model.UtenteLoggato;
import it.exolab.responces.RispostaDipendente;
import it.exolab.responces.RispostaDipendenti;

@Stateless
@LocalBean
public class DipendenteEJB extends BaseEJB implements DipendenteEJBRemote {

	public DipendenteEJB() {
	}

	@Override
	public RispostaDipendente add(Dipendente dipendente, UtenteLoggato utLog) {
		RispostaDipendente res = new RispostaDipendente();
		try {
			DipendenteDao.getIstanza().insert(dipendente, utLog);
			res.setData(dipendente);
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " ? richiesto");
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
	public RispostaDipendente edit(Dipendente dipendente) {
		RispostaDipendente res = new RispostaDipendente();
		try {
			DipendenteDao.getIstanza().update(dipendente);
			res.setData(dipendente);
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " ? richiesto");
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
	public RispostaDipendente updatePassword(Dipendente dipendente) {
		RispostaDipendente res = new RispostaDipendente();
		try {
			DipendenteDao.getIstanza().updatePassword(dipendente);
			res.setData(dipendente);
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " ? richiesto");
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
	public RispostaDipendente delete(Dipendente dipendente) {
		RispostaDipendente res = new RispostaDipendente();
		try {
			DipendenteDao.getIstanza().delete(dipendente);
			res.setData(dipendente);
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " ? richiesto");
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
	public RispostaDipendente login(Dipendente dipendente) {
		RispostaDipendente res = new RispostaDipendente();
		try {
			res.setData(DipendenteDao.getIstanza().login(dipendente));
		} catch (CredenzialiErrate e) {
			res.setErrore(e.getCredenziale());
			res.setCodice_errore(BaseEJB.ERR_CODE_CREDENTIALS); // successo viene impostato a false dentro il
																// setCodice_errore
			e.printStackTrace();
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " ? richiesto");
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
	public RispostaDipendenti selectByRuolo(String ruolo,Dipendente dipendente) {
		RispostaDipendenti res = new RispostaDipendenti();
		try {
			res.setData(DipendenteDao.getIstanza().selectByRuolo(ruolo,dipendente));
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " ? richiesto");
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
	public RispostaDipendenti allDipendenti(Dipendente dipendente) {
		RispostaDipendenti res = new RispostaDipendenti();
		try {
			res.setData(DipendenteDao.getIstanza().selectAll(dipendente));
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
	public RispostaDipendenti allJoinDipendentiEContratti(Dipendente dipendente) {
		RispostaDipendenti res = new RispostaDipendenti();
		try {
			res.setData(DipendenteDao.getIstanza().allJoinDipendentiEContratti(dipendente));
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
	public RispostaDipendenti allJoinDipendentiEPresenze(Dipendente dipendente) {
		RispostaDipendenti res = new RispostaDipendenti();
		try {
			res.setData(DipendenteDao.getIstanza().allJoinDipendentiEPresenze(dipendente));
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
