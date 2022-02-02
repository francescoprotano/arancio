package it.exolab.mapper;

import java.util.List;

import it.exolab.model.Contratto;



public interface ContrattoMapper {
	void insert(Contratto model);
	void delete(int id);
	void update(Contratto model);
	List<Contratto> all();

}
