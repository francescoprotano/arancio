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
		DipendentiDao.insert(dipendente);
		
	}

	@Override
	public void edit(int id) {
		DipendentiDao.update(id);
		
	}

	@Override
	public void delete(int id) {
		DipendentiDao.delete(id);
		
	}

	@Override
	public List<Dipendente> allDipendenti() {
		
		return DipendentiDao.all();
	}

}
