package it.exolab.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contratti")
public class Contratti {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_contratto;
	private Date data_assunzione;
	private Date data_scadenza;
	private String tipologia;
	private Integer id_dipendente_fk;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_dipendente_fk", nullable = false, insertable = false, updatable = false)
	private Dipendenti dipendenti;

	public Contratti() {

	}

	

	public Dipendenti getDipendenti() {
		return dipendenti;
	}



	public void setDipendenti(Dipendenti dipendenti) {
		this.dipendenti = dipendenti;
	}



	public Integer getId_contratto() {
		return id_contratto;
	}

	public void setId_contratto(Integer id_contratto) {
		this.id_contratto = id_contratto;
	}

	public Date getData_assunzione() {
		return data_assunzione;
	}

	public void setData_assunzione(Date data_assunzione) {
		this.data_assunzione = data_assunzione;
	}

	public Date getData_scadenza() {
		return data_scadenza;
	}

	public void setData_scadenza(Date data_scadenza) {
		this.data_scadenza = data_scadenza;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public Integer getId_dipendente_fk() {
		return id_dipendente_fk;
	}

	public void setId_dipendente_fk(Integer id_dipendente_fk) {
		this.id_dipendente_fk = id_dipendente_fk;
	}

	@Override
	public String toString() {
		return "Contratto [id_contratto=" + id_contratto + ", data_assunzione=" + data_assunzione + ", data_scadenza="
				+ data_scadenza + ", tipologia=" + tipologia + "]";
	}

}
