package it.exolab.mapper;

import java.util.List;

import it.exolab.model.Dipendente;


public interface DipendenteMapper {
	
	void insert(Dipendente dip);
	void update(Dipendente dip);
	void updatePassword(Dipendente dip);
	void delete(Integer id);
	
	List<Dipendente> selectByRuolo(String ruolo);
	List<Dipendente> selectAll();
	List<Dipendente> allJoinDipendentiEContratti();
	List<Dipendente> allJoinDipendentiEPresenze();
	
	Dipendente login(Dipendente dipendente);
	
}