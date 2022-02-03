package it.exolab.model;

import java.io.Serializable;
import java.sql.Date;

public class Contratto implements Serializable {

	private static final long serialVersionUID = -598097759965051785L;

	private Integer id_contratto;
	private Date data_assunzione;
	private Date data_scadenza;
	private String tipologia;
	private Integer id_dipendente_fk;

	public Contratto() {
	}

	public Contratto(Integer id_contratto, Date data_assunzione, Date data_scadenza, String tipologia,
			Integer id_dipendente_fk) {
		super();
		this.id_contratto = id_contratto;
		this.data_assunzione = data_assunzione;
		this.data_scadenza = data_scadenza;
		this.tipologia = tipologia;
		this.id_dipendente_fk = id_dipendente_fk;
	}

	public Integer getId_contratto() {
		return id_contratto;
	}

	public void setId_contratto(Integer id_contratto) {
		this.id_contratto = id_contratto;
	}

	public Date getData_assunzione() {
		return data_assunzione;
	}

	public void setData_assunzione(Date data_assunzione) {
		this.data_assunzione = data_assunzione;
	}

	public Date getData_scadenza() {
		return data_scadenza;
	}

	public void setData_scadenza(Date data_scadenza) {
		this.data_scadenza = data_scadenza;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public Integer getId_dipendente_fk() {
		return id_dipendente_fk;
	}

	public void setId_dipendente_fk(Integer id_dipendente_fk) {
		this.id_dipendente_fk = id_dipendente_fk;
	}

	@Override
	public String toString() {
		return "Contratto [id_contratto=" + id_contratto + ", data_assunzione=" + data_assunzione + ", data_scadenza="
				+ data_scadenza + ", tipologia=" + tipologia + ", id_dipendente_fk=" + id_dipendente_fk + "]";
	}

}
