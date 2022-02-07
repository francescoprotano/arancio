package it.exolab.service;

import java.sql.Date;

import it.exolab.exception.CampoRichiesto;
import it.exolab.model.Mese;

public class MeseService {

	private static MeseService istanza = null;

	private MeseService() {
	}

	public static MeseService getIstanza() {
		if (istanza == null) {
			istanza = new MeseService();
		}
		return istanza;
	}

	public static void validaID(Integer id_mese) throws CampoRichiesto {
		if (id_mese == null || id_mese.equals("")) {
			throw new CampoRichiesto("id mese");
		}
	}

	public static void validaMese(Mese mese) throws CampoRichiesto {
		MeseService.validaID(mese.getId_mese());
		MeseService.validaData(mese.getMese());
		
	}

	public static void validaData(Date mese) throws CampoRichiesto {
		if(mese==null||mese.equals("")) {
			throw new CampoRichiesto("mese");
		}		
	}

}