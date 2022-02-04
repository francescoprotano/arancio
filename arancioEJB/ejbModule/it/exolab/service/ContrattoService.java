package it.exolab.service;

import it.exolab.exception.CampoRichiesto;
import it.exolab.model.Contratto;

public class ContrattoService {

	private static ContrattoService istanza = null;

	private ContrattoService() {
	}

	public static ContrattoService getIstanza() {
		if (istanza == null) {
			istanza = new ContrattoService();
		}
		return istanza;
	}

	public static void validaID(Integer id_contratto) throws CampoRichiesto {
		if (id_contratto == null || id_contratto.equals("")) {
			throw new CampoRichiesto("id contratto");
		}
	}

	public static void validaTipologia(String tipologia) throws CampoRichiesto {
		if (tipologia == null || tipologia.equals("")) {
			throw new CampoRichiesto("tipologia");
		}
	}

	public static void validaContratto(Contratto contratto) throws CampoRichiesto {
		if (contratto.getData_assunzione() == null || contratto.getData_assunzione().equals("")) {
			throw new CampoRichiesto("Data assunzione");
		}
		if (contratto.getTipologia() == null || contratto.getTipologia().equals("")) {
			throw new CampoRichiesto("tipologia");
		}
		if (!contratto.getTipologia().equals("indeterminato")) {
			if (contratto.getData_scadenza() == null || contratto.getData_scadenza().equals("")) {
				throw new CampoRichiesto("data scadenza");
			}
		}
		if (contratto.getId_dipendente_fk() == null || contratto.getId_dipendente_fk().equals("")) {
			throw new CampoRichiesto("id dipendente");
		}
	}

}
