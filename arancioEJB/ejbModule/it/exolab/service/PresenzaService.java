package it.exolab.service;

import java.sql.Date;

import it.exolab.exception.CampoRichiesto;
import it.exolab.model.Presenza;

public class PresenzaService {

	private static PresenzaService istanza = null;

	private PresenzaService() {
	}

	public static PresenzaService getIstanza() {
		if (istanza == null) {
			istanza = new PresenzaService();
		}
		return istanza;
	}

	public static void validaID(Integer id_presenza) throws CampoRichiesto {
		if (id_presenza == null || id_presenza.equals("")) {
			throw new CampoRichiesto("id presenza");
		}
	}

	public static void validaData(Date data) throws CampoRichiesto {
		if (data == null || data.equals("")) {
			throw new CampoRichiesto("data");
		}
	}

	public static void validaIdMese(Integer id_mese_fk) throws CampoRichiesto {
		if (id_mese_fk == null || id_mese_fk.equals("")) {
			throw new CampoRichiesto("mese");
		}
	}

	public static void validaIdDipendente(Integer id_dipendente_fk) throws CampoRichiesto {
		if (id_dipendente_fk == null || id_dipendente_fk.equals("")) {
			throw new CampoRichiesto("dipendente");
		}
	}

	public static void validaMotivazioneAssenza(String motivazione_assenza_fk) throws CampoRichiesto {
		if (motivazione_assenza_fk == null || motivazione_assenza_fk.equals("")) {
			throw new CampoRichiesto("motivazione assenza");
		}
	}

	public static void validaPresenza(Presenza presenza) throws CampoRichiesto {
		if (presenza.getId_dipendente_fk() == null || presenza.getId_dipendente_fk().equals("")) {
			throw new CampoRichiesto("id dipendente");
		}
		if (presenza.getData() == null || presenza.getData().equals("")) {
			throw new CampoRichiesto("data");
		}
		if (presenza.getOre_lavorate() == null || presenza.getOre_lavorate().equals("")) {
			throw new CampoRichiesto("ore lavorate, se 0 scrivere 0");
		}
		if (presenza.getOre_assenza() == null || presenza.getOre_assenza().equals("")) {
			throw new CampoRichiesto("ore assenza, se 0 scrivere 0");
		}
		if (presenza.getMotivazione_assenza_fk() == null || presenza.getMotivazione_assenza_fk().equals("")) {
			throw new CampoRichiesto("motivazione assenza, se presente scrivere presente");
		}
		if (presenza.getId_mese_fk() == null || presenza.getId_mese_fk().equals("")) {
			throw new CampoRichiesto("mese");
		}
	}

}
