package it.exolab.exception;

import java.io.Serializable;

public class Risposta<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private Boolean successo;
	private String errore;
	private String codice_errore;
	private T data;

	public Risposta() {
		successo=true;
	}

	public Risposta(Boolean successo, String errore, String codice_errore, T data) {
		super();
		this.successo = successo;
		this.errore = errore;
		this.codice_errore = codice_errore;
		this.data = data;
	}

	public Boolean getSuccesso() {
		return successo;
	}

	public void setSuccesso(Boolean successo) {
		this.successo = successo;
	}

	public String getErrore() {
		return errore;
	}

	public void setErrore(String errore) {
		this.errore = errore;
	}

	public String getCodice_errore() {
		return codice_errore;
	}

	public void setCodice_errore(String codice_errore) {
		successo=false;
		this.codice_errore = codice_errore;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
