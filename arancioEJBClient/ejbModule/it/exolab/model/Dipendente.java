package it.exolab.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Dipendente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1629573878793697142L;
	
	public Dipendente() {
		
	}
	
	private int id_dipendente;
	private String nome;
	private String cognome;
	private Date data_nascita;
	private String email;
	private String password;
	private String ruolo;
	private List<Contratto> contratti = new ArrayList<>();
	private List<Presenza> presenze = new ArrayList<>();

	public int getId_dipendente() {
		return id_dipendente;
	}
	public void setId_dipendente(int id_dipendente) {
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
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public List<Contratto> getContratti() {
		return contratti;
	}
	public void setContratti(List<Contratto> contratti) {
		this.contratti = contratti;
	}
	public List<Presenza> getPresenze() {
		return presenze;
	}
	public void setPresenze(List<Presenza> presenze) {
		this.presenze = presenze;
	}
	@Override
	public String toString() {
		return "Dipendente [id_dipendente=" + id_dipendente + ", nome=" + nome + ", cognome=" + cognome
				+ ", data_nascita=" + data_nascita + ", email=" + email + ", password=" + password + ", ruolo=" + ruolo
				+ ", contratti=" + contratti + ", presenze=" + presenze + "]";
	}
	
	
}
