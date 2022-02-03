package it.exolab.mapper;

import java.util.List;

import it.exolab.model.Dipendente;


public interface DipendenteMapper {
	void insert(Dipendente model);
	void delete(int id);
	void update(Dipendente model);
	List<Dipendente> all();
	Dipendente selectByEmail(String email);

}
