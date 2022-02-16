package it.exolab.ejb;

import java.sql.Date;

import javax.ejb.Remote;

import it.exolab.model.Dipendente;
import it.exolab.model.Mese;
import it.exolab.responces.RispostaMese;
import it.exolab.responces.RispostaMesi;

@Remote
public interface MeseEJBRemote {
	
	public RispostaMese add(Dipendente dipendente);
	public RispostaMese edit(Mese mese,Dipendente dipendente);
	public RispostaMese delete(Mese mese,Dipendente dipendente);
	public RispostaMesi allMesi(Dipendente dipendente);
	public RispostaMese selectByMese(Date mese,Dipendente dipendente);

}
