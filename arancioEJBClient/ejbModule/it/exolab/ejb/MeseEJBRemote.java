package it.exolab.ejb;

import java.sql.Date;

import javax.ejb.Remote;

import it.exolab.model.Mese;
import it.exolab.responces.RispostaMese;
import it.exolab.responces.RispostaMesi;

@Remote
public interface MeseEJBRemote {
	
	public RispostaMese add(Mese mese);
	public RispostaMese edit(Mese mese);
	public RispostaMese delete(Mese mese);
	public RispostaMesi allMesi();
	public RispostaMese selectByMese(Date mese);

}
