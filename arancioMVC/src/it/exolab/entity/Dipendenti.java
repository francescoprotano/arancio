package it.exolab.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "dipendenti")
@NamedQuery(name = "Dipendenti.cercaPerIdCheIniziaPer", query = "select u from Dipendenti u where u.id_dipendente like ?1")
public class Dipendenti {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_dipendente;
	private String nome;
	private String cognome;
	private Date data_nascita;
	private String email;
	private String password;
	private String ruolo_fk;
	private Integer contratto_corrente_fk;

	@OneToMany(mappedBy = "dipendenti")
	private List<Contratti> contratti = new ArrayList<>();


	public Dipendenti() {

	}

	public Dipendenti(Integer id_dipendente, String nome, String cognome, Date data_nascita, String email,
			String password, String ruolo_fk, List<Contratti> contratti, List<Presenza> presenze) {
		super();
		this.id_dipendente = id_dipendente;
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.email = email;
		this.password = password;
		this.ruolo_fk = ruolo_fk;
		this.contratti = contratti;

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

	

	public List<Contratti> getContratti() {
		return contratti;
	}

	public void setContratti(List<Contratti> listaContratti) {
		this.contratti = listaContratti;
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

	

	@Override
	public String toString() {
		return "Dipendente [id_dipendente=" + id_dipendente + ", nome=" + nome + ", cognome=" + cognome
				+ ", data_nascita=" + data_nascita + ", email=" + email + ", password=" + password + ", ruolo=" + ruolo_fk
				+ ", contratti=" + contratto_corrente_fk + ", presenze="  + "]";
	}
}
