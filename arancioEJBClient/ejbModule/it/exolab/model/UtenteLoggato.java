package it.exolab.model;

public class UtenteLoggato {

	private Integer id_dipendente;
	private String email;
	private String ruolo_fk;
	private String nome;

	public Integer getId_dipendente() {
		return id_dipendente;
	}

	public void setId_dipendente(Integer id_dipendente) {
		this.id_dipendente = id_dipendente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRuolo_fk() {
		return ruolo_fk;
	}

	public void setRuolo_fk(String ruolo_fk) {
		this.ruolo_fk = ruolo_fk;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
