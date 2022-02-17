package it.exolab.model;

import java.io.Serializable;

public class Container implements Serializable {

	private static final long serialVersionUID = 1L;
	private Contratto con;
	private Dipendente dip;
	private DipendenteMese dipMes;
	private Mese mese;
	private Presenza pres;

	public Contratto getCon() {
		return con;
	}

	public void setCon(Contratto con) {
		this.con = con;
	}

	public Dipendente getDip() {
		return dip;
	}

	public void setDip(Dipendente dip) {
		this.dip = dip;
	}

	public DipendenteMese getDipMes() {
		return dipMes;
	}

	public void setDipMes(DipendenteMese dipMes) {
		this.dipMes = dipMes;
	}

	public Mese getMese() {
		return mese;
	}

	public void setMese(Mese mese) {
		this.mese = mese;
	}

	public Presenza getPres() {
		return pres;
	}

	public void setPres(Presenza pres) {
		this.pres = pres;
	}

}
