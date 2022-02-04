package it.exolab.ejb;

import java.util.List;

import javax.ejb.Remote;

import it.exolab.exception.Risposta;
import it.exolab.model.DipendenteMese;

@Remote
public interface DipendenteMeseEJBRemote {
	
	public Risposta add(DipendenteMese dipendenteMese);
	public Risposta update(DipendenteMese dipendenteMese);
	public Risposta delete(DipendenteMese dipendenteMese);
	public Risposta selectByID(Integer id_dipendente_fk, Integer id_mese_fk);
	public List<DipendenteMese> selectAll();

}
