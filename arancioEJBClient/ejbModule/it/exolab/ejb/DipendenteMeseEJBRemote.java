package it.exolab.ejb;

import javax.ejb.Remote;

import it.exolab.model.DipendenteMese;
import it.exolab.responces.RispostaDipendenteMese;

@Remote
public interface DipendenteMeseEJBRemote {
	
	public RispostaDipendenteMese update(DipendenteMese dipendenteMese);
	public RispostaDipendenteMese delete(DipendenteMese dipendenteMese);
	public RispostaDipendenteMese selectOne(DipendenteMese dipendenteMese);
	public RispostaDipendenteMese selectAll();
	public RispostaDipendenteMese selectByDipendente(DipendenteMese dipendenteMese);
	public RispostaDipendenteMese selectByMese(DipendenteMese dipendenteMese);
	public RispostaDipendenteMese selectByStato(DipendenteMese dipendenteMese);


}
