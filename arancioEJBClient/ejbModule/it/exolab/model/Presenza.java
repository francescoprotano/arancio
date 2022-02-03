package it.exolab.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Presenza implements Serializable {

	private static final long serialVersionUID = 3107236596255165538L;

	private Integer id_presenza;
	private Integer id_dipendente_fk;
	private Date data;
	private Integer ore_lavorate;
	private Integer ore_assenza;
	private String motivazione_assenza_fk;
	private Integer id_mese_fk;
	private List<Mese> mesi = new ArrayList<Mese>();

	public Presenza() {
	}

	public Presenza(Integer id_presenza, Integer id_dipendente_fk, Date data, Integer ore_lavorate, Integer ore_assenza,
			String motivazione_assenza_fk, Integer id_mese_fk, List<Mese> mesi) {
		super();
		this.id_presenza = id_presenza;
		this.id_dipendente_fk = id_dipendente_fk;
		this.data = data;
		this.ore_lavorate = ore_lavorate;
		this.ore_assenza = ore_assenza;
		this.motivazione_assenza_fk = motivazione_assenza_fk;
		this.id_mese_fk = id_mese_fk;
		this.mesi = mesi;
	}

	public Integer getId_presenza() {
		return id_presenza;
	}

	public void setId_presenza(Integer id_presenza) {
		this.id_presenza = id_presenza;
	}

	public Integer getId_dipendente_fk() {
		return id_dipendente_fk;
	}

	public void setId_dipendente_fk(Integer id_dipendente_fk) {
		this.id_dipendente_fk = id_dipendente_fk;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getOre_lavorate() {
		return ore_lavorate;
	}

	public void setOre_lavorate(Integer ore_lavorate) {
		this.ore_lavorate = ore_lavorate;
	}

	public Integer getOre_assenza() {
		return ore_assenza;
	}

	public void setOre_assenza(Integer ore_assenza) {
		this.ore_assenza = ore_assenza;
	}

	public String getMotivazione_assenza_fk() {
		return motivazione_assenza_fk;
	}

	public void setMotivazione_assenza_fk(String motivazione_assenza_fk) {
		this.motivazione_assenza_fk = motivazione_assenza_fk;
	}

	public Integer getId_mese_fk() {
		return id_mese_fk;
	}

	public void setId_mese_fk(Integer id_mese_fk) {
		this.id_mese_fk = id_mese_fk;
	}

	public List<Mese> getMesi() {
		return mesi;
	}

	public void setMesi(List<Mese> mesi) {
		this.mesi = mesi;
	}

	@Override
	public String toString() {
		return "Presenza [id_presenza=" + id_presenza + ", id_dipendente_fk=" + id_dipendente_fk + ", data=" + data
				+ ", ore_lavorate=" + ore_lavorate + ", ore_assenza=" + ore_assenza + ", motivazione_assenza_fk="
				+ motivazione_assenza_fk + ", id_mese_fk=" + id_mese_fk + ", mesi=" + mesi + "]";
	}

}
