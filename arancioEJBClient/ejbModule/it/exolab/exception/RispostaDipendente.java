package it.exolab.exception;

import java.util.List;

import it.exolab.model.Dipendente;

public class RispostaDipendente extends Risposta<Dipendente> {

	private static final long serialVersionUID = 1L;

	private List<Dipendente> dipendenti;
	private Integer id_dipendente;

	public void setData(Integer id_dipendente) {
		this.id_dipendente = id_dipendente;
	}

	public Integer getId_dipendente() {
		return id_dipendente;
	}

	public void setData(List<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}

	public List<Dipendente> getDipendenti() {
		return dipendenti;
	}

}
