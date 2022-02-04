package it.exolab.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.PresenzaDao;
import it.exolab.model.Presenza;

@Stateless
@LocalBean
public class PresenzaEJB implements PresenzaEJBRemote {

	public PresenzaEJB() {

	}

	@Override
	public void add(Presenza presenza) {
		PresenzaDao.insert(presenza);

	}

	@Override
	public void edit(Presenza presenza) {
		PresenzaDao.update(presenza);

	}

	@Override
	public void delete(int id) {
		PresenzaDao.delete(id);

	}

	@Override
	public List<Presenza> allPresenze() {

		return PresenzaDao.all();
	}

}
