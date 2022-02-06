package it.exolab.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Dipendente implements Serializable {

	private static final long serialVersionUID = 239504350187104834L;

	private Integer id_dipendente;
	private String nome;
	private String cognome;
	private Date data_nascita;
	private String email;
	private String password;
	private String ruolo_fk;
	private Integer contratto_corrente_fk;
	private List<Presenza> presenze = new ArrayList<>();
	private List<DipendenteMese> dipendentiMesi = new ArrayList<>();

	public Dipendente() {
	}

	public Dipendente(Integer id_dipendente, String nome, String cognome, Date data_nascita, String email,
			String password, String ruolo_fk, Integer contratto_corrente_fk, List<Presenza> presenze,
			List<DipendenteMese> dipendentiMesi) {
		super();
		this.id_dipendente = id_dipendente;
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.email = email;
		this.password = password;
		this.ruolo_fk = ruolo_fk;
		this.contratto_corrente_fk = contratto_corrente_fk;
		this.presenze = presenze;
		this.dipendentiMesi = dipendentiMesi;
	}

	public Integer getId_dipendente() {
		return id_dipendente;
	}

	public void setId_dipendente(Integer id_dipendente) {
		this.id_dipendente = id_dipendente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRuolo_fk() {
		return ruolo_fk;
	}

	public void setRuolo_fk(String ruolo_fk) {
		this.ruolo_fk = ruolo_fk;
	}

	public Integer getContratto_corrente_fk() {
		return contratto_corrente_fk;
	}

	public void setContratto_corrente_fk(Integer contratto_corrente_fk) {
		this.contratto_corrente_fk = contratto_corrente_fk;
	}

	public List<Presenza> getPresenze() {
		return presenze;
	}

	public void setPresenze(List<Presenza> presenze) {
		this.presenze = presenze;
	}

	public List<DipendenteMese> getDipendentiMesi() {
		return dipendentiMesi;
	}

	public void setDipendentiMesi(List<DipendenteMese> dipendentiMesi) {
		this.dipendentiMesi = dipendentiMesi;
	}

	@Override
	public String toString() {
		return "Dipendente [id_dipendente=" + id_dipendente + ", nome=" + nome + ", cognome=" + cognome
				+ ", data_nascita=" + data_nascita + ", email=" + email + ", password=" + password + ", ruolo_fk="
				+ ruolo_fk + ", contratto_corrente_fk=" + contratto_corrente_fk + ", presenze=" + presenze
				+ ", dipendentiMesi=" + dipendentiMesi + "]";
	}

}