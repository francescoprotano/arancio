package it.exolab.ejb;

import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;

import it.exolab.exception.Risposta;
import it.exolab.model.Presenza;

@Remote
public interface PresenzaEJBRemote {
	
	public Risposta add(Presenza presenza);
	public Risposta edit(Presenza presenza);
	public Risposta delete(Integer id_presenza);
	public Risposta selectByData(Date data);
	public Risposta selectByMese(Integer id_mese_fk);
	public Risposta selectByDipendente(Integer id_dipendente_fk);
	public Risposta selectByAssenza(String motivazione_assenza_fk);
	public List<Presenza> selectAll();
	
}
