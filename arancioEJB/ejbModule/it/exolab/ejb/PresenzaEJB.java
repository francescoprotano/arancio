package it.exolab.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exolab.dao.PresenzeDao;
import it.exolab.model.Presenza;

@Stateless
@LocalBean
public class PresenzaEJB implements PresenzaEJBRemote {

	public PresenzaEJB() {

	}

	@Override
	public void add(Presenza presenza) {
		PresenzeDao.insert(presenza);

	}

	@Override
	public void edit(Presenza presenza) {
		PresenzeDao.update(presenza);

	}

	@Override
	public void delete(int id) {
		PresenzeDao.delete(id);

	}

	@Override
	public List<Presenza> allPresenze() {

		return PresenzeDao.all();
	}

}
