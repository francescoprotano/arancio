package it.exolab.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.exception.Risposta;
import it.exolab.model.Mese;

@Stateless
@LocalBean
public class MeseEJB implements MeseEJBRemote {

    public MeseEJB() {
    }

	@Override
	public Risposta add(Mese mese) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Risposta edit(Mese mese) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Risposta delete(Integer id_mese) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Risposta selectByID(Integer id_mese) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mese> allMesi() {
		// TODO Auto-generated method stub
		return null;
	}

}
