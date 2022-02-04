package it.exolab.mapper;

import java.util.List;

import it.exolab.model.Dipendente;


public interface DipendenteMapper {
	void insert(Dipendente dip);
	void delete(Integer id);
	void update(Dipendente dip);
	List<Dipendente> all();
	Dipendente selectByEmail(String email);

}
