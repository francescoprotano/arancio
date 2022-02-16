package it.exolab.ejb;

import java.sql.Date;

import javax.ejb.Remote;

import it.exolab.model.Dipendente;
import it.exolab.model.Presenza;
import it.exolab.responces.RispostaPresenza;
import it.exolab.responces.RispostaPresenze;

@Remote
public interface PresenzaEJBRemote {
	
	public RispostaPresenza add(Presenza presenza,Dipendente dipendente);
	public RispostaPresenza edit(Presenza presenza,Dipendente dipendente);
	public RispostaPresenza delete(Presenza presenza,Dipendente dipendente);
	public RispostaPresenze selectByData(Date data,Dipendente dipendente);
	public RispostaPresenze selectByMese(Integer id_mese_fk,Dipendente dipendente);
	public RispostaPresenze selectByDipendente(Integer id_dipendente_fk,Dipendente dipendente);
	public RispostaPresenze selectByAssenza(String motivazione_assenza_fk,Dipendente dipendente);
	public RispostaPresenze selectAll(Dipendente dipendente);
	public RispostaPresenze presenzeJoinmesi(Date data,Dipendente dipendente);
	
}
