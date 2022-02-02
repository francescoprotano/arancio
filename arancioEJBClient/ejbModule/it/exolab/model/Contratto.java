package it.exolab.model;

import java.io.Serializable;
import java.sql.Date;

public class Contratto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -598097759965051785L;

	private int id_contratto;
	private Date data_assunzione;
	private Date data_scadenza;
	private String tipologia;
	
	public Contratto() {
		
	}
	
	
	
	public Contratto(int id_contratto, Date data_assunzione, Date data_scadenza, String tipologia) {
		super();
		this.id_contratto = id_contratto;
		this.data_assunzione = data_assunzione;
		this.data_scadenza = data_scadenza;
		this.tipologia = tipologia;
	}



	public int getId_contratto() {
		return id_contratto;
	}
	public void setId_contratto(int id_contratto) {
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
	@Override
	public String toString() {
		return "Contratto [id_contratto=" + id_contratto + ", data_assunzione=" + data_assunzione + ", data_scadenza="
				+ data_scadenza + ", tipologia=" + tipologia + "]";
	}
	
	
}
