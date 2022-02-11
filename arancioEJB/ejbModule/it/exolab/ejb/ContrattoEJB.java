package it.exolab.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.ContrattoDao;
import it.exolab.exception.CampoRichiesto;
import it.exolab.exception.ErroreGenerico;
import it.exolab.model.Contratto;
import it.exolab.responces.RispostaContratto;

@Stateless
@LocalBean
public class ContrattoEJB extends BaseEJB implements ContrattoEJBRemote {

	public ContrattoEJB() {
	}

	@Override
	public RispostaContratto add(Contratto contratto) {
		RispostaContratto res = new RispostaContratto();
		try {
			ContrattoDao.getIstanza().insert(contratto);
			res.setData(contratto);
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
	public RispostaContratto edit(Contratto contratto) {
		RispostaContratto res = new RispostaContratto();
		try {
			ContrattoDao.getIstanza().update(contratto);
			res.setData(contratto);
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
	public RispostaContratto delete(Integer id_contratto) {
		RispostaContratto res = new RispostaContratto();
		try {
			ContrattoDao.getIstanza().delete(id_contratto);
			res.setData(id_contratto);
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
	public RispostaContratto selectByID(Integer id_contratto) {
		RispostaContratto res = new RispostaContratto();
		try {
			res.setData(ContrattoDao.getIstanza().selectByID(id_contratto));
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
	public List<Contratto> selectByTipologia(String tipologia) {
		
		RispostaContratto res = new RispostaContratto();
		try {
			res.setData(ContrattoDao.getIstanza().selectByTipologia(tipologia));
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
		try {
			return ContrattoDao.getIstanza().selectByTipologia(tipologia);
		} catch (CampoRichiesto | ErroreGenerico e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Contratto> allContratti() {
		return ContrattoDao.getIstanza().selectAll();
	}

}
