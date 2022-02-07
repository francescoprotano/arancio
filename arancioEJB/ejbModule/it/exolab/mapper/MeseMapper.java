package it.exolab.mapper;

import java.util.List;

import it.exolab.model.Mese;

public interface MeseMapper {
	
	void insert(Mese mese);
	void update(Mese mese);
	void delete(Integer id_mese);
	List<Mese> selectAll();

}
