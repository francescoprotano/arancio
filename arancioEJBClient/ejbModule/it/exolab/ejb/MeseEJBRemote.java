package it.exolab.ejb;

import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;

import it.exolab.exception.RispostaMese;
import it.exolab.model.Mese;

@Remote
public interface MeseEJBRemote {
	
	public RispostaMese add(Mese mese);
	public RispostaMese edit(Mese mese);
	public RispostaMese delete(Integer id_mese);
	public List<Mese> allMesi();
	public RispostaMese selectByMese(Date mese);

}
