package it.exolab.model;

import java.io.Serializable;
import java.sql.Date;

public class Presenza implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3107236596255165538L;
	
	private int id_presenza;
	private Date data;
	private String motivazione_assenza_fk;
	private int id_dipendente_fk;
	private boolean compilabile;
	private boolean controllata;
	private boolean chiusa;
	
	
	public Presenza() {
		
	}


	public Presenza(int id_presenza, Date data, String motivazione_assenza_fk, int id_dipendente_fk,
			boolean compilabile, boolean controllata, boolean chiusa) {
		super();
		this.id_presenza = id_presenza;
		this.data = data;
		this.motivazione_assenza_fk = motivazione_assenza_fk;
		this.id_dipendente_fk = id_dipendente_fk;
		this.compilabile = compilabile;
		this.controllata = controllata;
		this.chiusa = chiusa;
	}


	public int getId_presenza() {
		return id_presenza;
	}


	public void setId_presenza(int id_presenza) {
		this.id_presenza = id_presenza;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public String getMotivazione_assenza_fk() {
		return motivazione_assenza_fk;
	}


	public void setMotivazione_assenza_fk(String motivazione_assenza_fk) {
		this.motivazione_assenza_fk = motivazione_assenza_fk;
	}


	public int getId_dipendente_fk() {
		return id_dipendente_fk;
	}


	public void setId_dipendente_fk(int id_dipendente_fk) {
		this.id_dipendente_fk = id_dipendente_fk;
	}


	public boolean isCompilabile() {
		return compilabile;
	}


	public void setCompilabile(boolean compilabile) {
		this.compilabile = compilabile;
	}


	public boolean isControllata() {
		return controllata;
	}


	public void setControllata(boolean controllata) {
		this.controllata = controllata;
	}


	public boolean isChiusa() {
		return chiusa;
	}


	public void setChiusa(boolean chiusa) {
		this.chiusa = chiusa;
	}
	
	
	
}
