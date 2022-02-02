package it.exolab.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.ContrattiDao;
import it.exolab.model.Contratto;

@Stateless
@LocalBean
public class ContrattoEJB implements ContrattoEJBRemote {

	public ContrattoEJB() {

	}

	@Override
	public void add(Contratto contratto) {
		ContrattiDao.insert(contratto);

	}

	@Override
	public void edit(Contratto contratto) {
		ContrattiDao.update(contratto);

	}

	@Override
	public void delete(int id) {
		ContrattiDao.delete(id);

	}

	@Override
	public List<Contratto> allContratti() {

		return ContrattiDao.all();
	}

}
