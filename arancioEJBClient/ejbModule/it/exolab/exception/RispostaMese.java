package it.exolab.exception;

import it.exolab.model.Mese;

public class RispostaMese extends Risposta<Mese> {

	private static final long serialVersionUID = 1L;
	
	private Integer id_mese;

	public void setData(Integer id_mese) {
		this.id_mese=id_mese;		
	}
	
	public Integer getD() {
		return id_mese;
	}

}
