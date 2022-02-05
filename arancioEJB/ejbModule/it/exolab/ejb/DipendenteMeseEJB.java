package it.exolab.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.exception.Risposta;
import it.exolab.model.DipendenteMese;

@Stateless
@LocalBean
public class DipendenteMeseEJB implements DipendenteMeseEJBRemote {

    public DipendenteMeseEJB() {
    }

	@Override
	public Risposta add(DipendenteMese dipendenteMese) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Risposta update(DipendenteMese dipendenteMese) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Risposta delete(DipendenteMese dipendenteMese) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Risposta selectByID(Integer id_dipendente_fk, Integer id_mese_fk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DipendenteMese> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
