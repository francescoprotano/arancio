package it.exolab.model;

import java.io.Serializable;
import java.sql.Date;

public class Presenza implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3107236596255165538L;
	
	private int id_presenza;
	private Date ora_entrata;
	private Date ora_uscita;
	private String motivazione_assenza;
	public int getId_presenza() {
		return id_presenza;
	}
	public void setId_presenza(int id_presenza) {
		this.id_presenza = id_presenza;
	}
	public Date getOra_entrata() {
		return ora_entrata;
	}
	public void setOra_entrata(Date ora_entrata) {
		this.ora_entrata = ora_entrata;
	}
	public Date getOra_uscita() {
		return ora_uscita;
	}
	public void setOra_uscita(Date ora_uscita) {
		this.ora_uscita = ora_uscita;
	}
	public String getMotivazione_assenza() {
		return motivazione_assenza;
	}
	public void setMotivazione_assenza(String motivazione_assenza) {
		this.motivazione_assenza = motivazione_assenza;
	}
	
	
	
	
	
	
}
