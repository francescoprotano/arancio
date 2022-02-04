package it.exolab.mapper;

import java.util.List;

import it.exolab.model.Contratto;



public interface ContrattoMapper {
	void insert(Contratto contratto);
	void update(Contratto contratto);
	void delete(Integer id_contratto);
	Contratto selectByID(Integer id_contratto);
	List<Contratto> selectByTipologia(String tipologia);
	List<Contratto> selectAll();

}
