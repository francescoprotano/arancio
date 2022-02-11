package it.exolab.exception;

public class CampoRichiesto extends Exception {

	private static final long serialVersionUID = 1L;
	private String campo;

	public CampoRichiesto(String campo) {
		super();
		this.campo = campo;
	}

	public String getCampo() {
		return campo;
	}
}
