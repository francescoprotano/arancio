package it.exolab.ejb;

import javax.ejb.Remote;

import it.exolab.model.DipendenteMese;
import it.exolab.responces.RispostaDipendenteMese;
import it.exolab.responces.RispostaDipendentiMesi;

@Remote
public interface DipendenteMeseEJBRemote {
	
	public RispostaDipendenteMese update(DipendenteMese dipendenteMese);
	public RispostaDipendenteMese delete(DipendenteMese dipendenteMese);
	public RispostaDipendenteMese selectOne(DipendenteMese dipendenteMese);
	public RispostaDipendentiMesi selectAll();
	public RispostaDipendentiMesi selectByDipendente(DipendenteMese dipendenteMese);
	public RispostaDipendentiMesi selectByMese(DipendenteMese dipendenteMese);
	public RispostaDipendentiMesi selectByStato(DipendenteMese dipendenteMese);


}
