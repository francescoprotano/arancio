package it.exolab.ejb;

import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;

import it.exolab.exception.Risposta;
import it.exolab.model.Mese;

@Remote
public interface MeseEJBRemote {
	
	public Risposta add(Mese mese);
	public Risposta edit(Mese mese);
	public Risposta delete(Integer id_mese);
	public List<Mese> allMesi();
	public Risposta selectByMese(Date mese);

}
