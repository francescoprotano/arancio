package it.exolab.ejb;

import java.sql.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.PresenzaDao;
import it.exolab.exception.CampoRichiesto;
import it.exolab.exception.ErroreGenerico;
import it.exolab.model.Presenza;
import it.exolab.responces.RispostaPresenza;
import it.exolab.responces.RispostaPresenze;

@Stateless
@LocalBean
public class PresenzaEJB implements PresenzaEJBRemote {

	public PresenzaEJB() {
	}

	@Override
	public RispostaPresenza add(Presenza presenza) {
		RispostaPresenza res = new RispostaPresenza();
		try {
			PresenzaDao.getIstanza().insert(presenza);
			res.setData(presenza);
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " � richiesto");
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
	public RispostaPresenza edit(Presenza presenza) {
		RispostaPresenza res = new RispostaPresenza();
		try {
			PresenzaDao.getIstanza().update(presenza);
			res.setData(presenza);
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " � richiesto");
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
	public RispostaPresenza delete(Presenza presenza) {
		RispostaPresenza res = new RispostaPresenza();
		try {
			PresenzaDao.getIstanza().delete(presenza);
			res.setData(presenza);
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " � richiesto");
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
	public RispostaPresenze selectByData(Date data) {
		RispostaPresenze res = new RispostaPresenze();
		try {
			res.setData(PresenzaDao.getIstanza().selectByData(data));
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " � richiesto");
			res.setCodice_errore(BaseEJB.ERR_CODE_REQUIRED); // successo viene impostato a false dentro il// setCodice_errore
			e.printStackTrace();
		} catch (ErroreGenerico e) {
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il// setCodice_errore
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
	public RispostaPresenze selectByMese(Integer id_mese_fk) {
		RispostaPresenze res = new RispostaPresenze();
		try {
			res.setData(PresenzaDao.getIstanza().selectByMese(id_mese_fk));
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " � richiesto");
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
	public RispostaPresenze selectByDipendente(Integer id_dipendente_fk) {
		RispostaPresenze res = new RispostaPresenze();
		try {
			res.setData(PresenzaDao.getIstanza().selectByDipendente(id_dipendente_fk));
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " � richiesto");
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
	public RispostaPresenze selectByAssenza(String motivazione_assenza_fk) {
		RispostaPresenze res = new RispostaPresenze();
		try {
			res.setData(PresenzaDao.getIstanza().selectByAssenza(motivazione_assenza_fk));
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " � richiesto");
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
	public RispostaPresenze selectAll() {
		RispostaPresenze res = new RispostaPresenze();
		try {
			res.setData(PresenzaDao.getIstanza().selectAll());
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
	public RispostaPresenze presenzeJoinmesi(Date data) {
		RispostaPresenze res = new RispostaPresenze();
		try {
			res.setData(PresenzaDao.getIstanza().presenzeJoinmesi(data));
		} catch (CampoRichiesto e) {
			res.setErrore(e.getCampo() + " � richiesto");
			res.setCodice_errore(BaseEJB.ERR_CODE_REQUIRED); // successo viene impostato a false dentro il// setCodice_errore
			e.printStackTrace();
		} catch (ErroreGenerico e) {
			res.setErrore(BaseEJB.ERR_GENERAL);
			res.setCodice_errore(BaseEJB.ERR_CODE_GENERAL); // successo viene impostato a false dentro il// setCodice_errore
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
