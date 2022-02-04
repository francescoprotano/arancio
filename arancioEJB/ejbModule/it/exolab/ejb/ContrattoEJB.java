package it.exolab.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.ContrattoDao;
import it.exolab.model.Contratto;

@Stateless
@LocalBean
public class ContrattoEJB implements ContrattoEJBRemote {

	public ContrattoEJB() {

	}

	@Override
	public void add(Contratto contratto) {
		ContrattoDao.insert(contratto);

	}

	@Override
	public void edit(Contratto contratto) {
		ContrattoDao.update(contratto);

	}

	@Override
	public void delete(int id) {
		ContrattoDao.delete(id);

	}

	@Override
	public List<Contratto> allContratti() {

		return ContrattoDao.all();
	}

}
