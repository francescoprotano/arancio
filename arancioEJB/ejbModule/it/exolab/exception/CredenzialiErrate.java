package it.exolab.exception;

public class CredenzialiErrate extends Exception {

	private static final long serialVersionUID = 1L;
	private String credenziale;
	
	public CredenzialiErrate(String credenziale) {
		super();
		this.credenziale = credenziale;
	}
	public String getCredenziale() {
		return credenziale;
	}
	
}
