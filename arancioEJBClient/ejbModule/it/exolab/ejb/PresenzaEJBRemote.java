package it.exolab.ejb;

import java.sql.Date;

import javax.ejb.Remote;

import it.exolab.model.Presenza;
import it.exolab.responces.RispostaPresenza;
import it.exolab.responces.RispostaPresenze;

@Remote
public interface PresenzaEJBRemote {
	
	public RispostaPresenza add(Presenza presenza);
	public RispostaPresenza edit(Presenza presenza);
	public RispostaPresenza delete(Presenza presenza);
	public RispostaPresenze selectByData(Date data);
	public RispostaPresenze selectByMese(Integer id_mese_fk);
	public RispostaPresenze selectByDipendente(Integer id_dipendente_fk);
	public RispostaPresenze selectByAssenza(String motivazione_assenza_fk);
	public RispostaPresenze selectAll();
	
}
