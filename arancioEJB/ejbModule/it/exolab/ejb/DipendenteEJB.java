package it.exolab.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.DipendentiDao;
import it.exolab.model.Dipendente;

/**
 * Session Bean implementation class GestionePresenzeEJB
 */
@Stateless
@LocalBean
public class DipendenteEJB implements DipendenteEJBRemote {

    
    public DipendenteEJB() {
        
    }

	@Override
	public void add(Dipendente dipendente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Dipendente> allDipendenti() {
		
		return DipendentiDao.all();
	}

}
