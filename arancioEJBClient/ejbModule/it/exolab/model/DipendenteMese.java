package it.exolab.model;

import java.io.Serializable;

public class DipendenteMese implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id_dipendente_fk;
	private Integer id_mese_fk;
	private Integer stato;

	public DipendenteMese() {
	}

	public DipendenteMese(Integer id_dipendente_fk, Integer id_mese_fk, Integer stato) {
		super();
		this.id_dipendente_fk = id_dipendente_fk;
		this.id_mese_fk = id_mese_fk;
		this.stato = stato;
	}

	public Integer getId_dipendente_fk() {
		return id_dipendente_fk;
	}

	public void setId_dipendente_fk(Integer id_dipendente_fk) {
		this.id_dipendente_fk = id_dipendente_fk;
	}

	public Integer getId_mese_fk() {
		return id_mese_fk;
	}

	public void setId_mese_fk(Integer id_mese_fk) {
		this.id_mese_fk = id_mese_fk;
	}

	public Integer getStato() {
		return stato;
	}

	public void setStato(Integer stato) {
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "DipendenteMese [id_dipendente_fk=" + id_dipendente_fk + ", id_mese_fk=" + id_mese_fk + ", stato="
				+ stato + "]";
	}

}
