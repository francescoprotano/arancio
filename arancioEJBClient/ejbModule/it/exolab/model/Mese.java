package it.exolab.model;

import java.io.Serializable;
import java.sql.Date;

public class Mese implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id_mese;
	private Date mese;
	private Boolean chiuso;

	public Mese() {
	}

	public Mese(Integer id_mese, Date mese, Boolean chiuso) {
		super();
		this.id_mese = id_mese;
		this.mese = mese;
		this.chiuso = chiuso;
	}

	public Integer getId_mese() {
		return id_mese;
	}

	public void setId_mese(Integer id_mese) {
		this.id_mese = id_mese;
	}

	public Date getMese() {
		return mese;
	}

	public void setMese(Date mese) {
		this.mese = mese;
	}

	public Boolean getChiuso() {
		return chiuso;
	}

	public void setChiuso(Boolean chiuso) {
		this.chiuso = chiuso;
	}

	@Override
	public String toString() {
		return "Mese [id_mese=" + id_mese + ", mese=" + mese + ", chiuso=" + chiuso + "]";
	}

}
