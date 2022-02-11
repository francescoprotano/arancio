package it.exolab.ejb;

import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;

import it.exolab.model.Presenza;
import it.exolab.responces.RispostaPresenza;

@Remote
public interface PresenzaEJBRemote {
	
	public RispostaPresenza add(Presenza presenza);
	public RispostaPresenza edit(Presenza presenza);
	public RispostaPresenza delete(Integer id_presenza);
	public RispostaPresenza selectByData(Date data);
	public RispostaPresenza selectByMese(Integer id_mese_fk);
	public RispostaPresenza selectByDipendente(Integer id_dipendente_fk);
	public RispostaPresenza selectByAssenza(String motivazione_assenza_fk);
	public List<Presenza> selectAll();
	
}
