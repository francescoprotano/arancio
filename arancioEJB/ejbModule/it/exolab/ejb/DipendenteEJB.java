package it.exolab.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.DipendenteDao;
import it.exolab.exception.CampoRichiesto;
import it.exolab.exception.ErroreGenerico;
import it.exolab.exception.RispostaDipendente;
import it.exolab.model.Dipendente;

@Stateless
@LocalBean
public class DipendenteEJB extends BaseEJB implements DipendenteEJBRemote {

	public DipendenteEJB() {
	}

	@Override
	public RispostaDipendente add(Dipendente dipendente) {
		RispostaDipendente res = new RispostaDipendente();
		try {
			DipendenteDao.getIstanza().insert(dipendente);
			res.setData(dipendente);
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore(BaseEJB.ERR_CODE_REQUIRED); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}catch (ErroreGenerico e) {
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il setCodice_errore
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
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore(BaseEJB.ERR_CODE_REQUIRED); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}catch (ErroreGenerico e) {
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il setCodice_errore
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
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore(BaseEJB.ERR_CODE_REQUIRED); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}catch (ErroreGenerico e) {
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public RispostaDipendente delete(Integer id_dipendente) {
		RispostaDipendente res = new RispostaDipendente();
		try {
			DipendenteDao.getIstanza().delete(id_dipendente);
			res.setData("");
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore(BaseEJB.ERR_CODE_REQUIRED); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}catch (ErroreGenerico e) {
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public RispostaDipendente selectByEmail(String email) {
		RispostaDipendente res = new RispostaDipendente();
		try {
			res.setData(DipendenteDao.getIstanza().selectByEmail(email));
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore(BaseEJB.ERR_CODE_REQUIRED); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}catch (ErroreGenerico e) {
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public RispostaDipendente selectByRuolo(String ruolo) {
		RispostaDipendente res = new RispostaDipendente();
		try {
			res.setData(DipendenteDao.getIstanza().selectByRuolo(ruolo));
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " è richiesto");
			res.setCodice_errore(BaseEJB.ERR_CODE_REQUIRED); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}catch (ErroreGenerico e) {
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il setCodice_errore
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Dipendente> allDipendenti() {
		return DipendenteDao.getIstanza().selectAll();
	}

	@Override
	public List<Dipendente> allJoinDipendentiEContratti() {
		
		return DipendenteDao.getIstanza().allJoinDipendentiEContratti();
	}

	@Override
	public List<Dipendente> allJoinDipendentiEPresenze() {
		
		return DipendenteDao.getIstanza().allJoinDipendentiEPresenze();
	}

}
