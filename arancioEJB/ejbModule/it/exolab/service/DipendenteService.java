package it.exolab.service;

import it.exolab.exception.CampoRichiesto;
import it.exolab.model.Dipendente;

public class DipendenteService {

	private static DipendenteService istanza = null;

	private DipendenteService() {
	}

	public static DipendenteService getIstanza() {
		if (istanza == null) {
			istanza = new DipendenteService();
		}
		return istanza;
	}

	public static void validaID(Integer id_dipendente) throws CampoRichiesto {
		if (id_dipendente == null || id_dipendente.equals("")) {
			throw new CampoRichiesto("id dipendente");
		}
	}

	public static void validaEmail(String email) throws CampoRichiesto {
		if (email == null || email.equals("")) {
			throw new CampoRichiesto("email");
		}
	}

	public static void validaRuolo(String ruolo) throws CampoRichiesto {
		if (ruolo == null || ruolo.equals("")) {
			throw new CampoRichiesto("ruolo");
		}
	}

	public static void validaInsert(Dipendente dip) throws CampoRichiesto {
		if (dip.getEmail() == null || dip.getEmail().equals("")) {
			throw new CampoRichiesto("e-mail");
		}
		if (dip.getPassword() == null || dip.getPassword().equals("")) {
			throw new CampoRichiesto("password");
		}
		if (dip.getRuolo_fk() == null || dip.getRuolo_fk().equals("")) {
			throw new CampoRichiesto("ruolo");
		}
	}

	public static void validaUpdate(Dipendente dip) throws CampoRichiesto {
		if (dip.getId_dipendente() == null || dip.getId_dipendente().equals("")) {
			throw new CampoRichiesto("id dipendente");
		}
		if (dip.getNome() == null || dip.getNome().equals("")) {
			throw new CampoRichiesto("nome");
		}
		if (dip.getCognome() == null || dip.getCognome().equals("")) {
			throw new CampoRichiesto("cognome");
		}
		if (dip.getData_nascita() == null || dip.getData_nascita().equals("")) {
			throw new CampoRichiesto("data di nascita");
		}
		DipendenteService.validaInsert(dip);
	}

	public static void validaPassword(Dipendente dip) throws CampoRichiesto {
		if (dip.getPassword() == null || dip.getPassword().equals("")) {
			throw new CampoRichiesto("password");
		}
	}

}
