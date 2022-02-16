package it.exolab.ejb;

import javax.ejb.Remote;

import it.exolab.model.Dipendente;
import it.exolab.model.DipendenteMese;
import it.exolab.responces.RispostaDipendenteMese;
import it.exolab.responces.RispostaDipendentiMesi;

@Remote
public interface DipendenteMeseEJBRemote {
	
	public RispostaDipendenteMese update(DipendenteMese dipendenteMese,Dipendente dipendente);
	public RispostaDipendenteMese delete(DipendenteMese dipendenteMese,Dipendente dipendente);
	public RispostaDipendenteMese selectOne(DipendenteMese dipendenteMese,Dipendente dipendente);
	public RispostaDipendentiMesi selectAll(Dipendente dipendente);
	public RispostaDipendentiMesi selectByDipendente(DipendenteMese dipendenteMese,Dipendente dipendente);
	public RispostaDipendentiMesi selectByMese(DipendenteMese dipendenteMese,Dipendente dipendente);
	public RispostaDipendentiMesi selectByStato(DipendenteMese dipendenteMese,Dipendente dipendente);


}
