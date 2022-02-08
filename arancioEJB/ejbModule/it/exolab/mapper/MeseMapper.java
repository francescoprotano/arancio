package it.exolab.mapper;

import java.sql.Date;
import java.util.List;

import it.exolab.model.Mese;

public interface MeseMapper {
	
	void insert(Mese mese);
	void inserisciDipendeti_Mesi(Integer id_mese, Integer id_dipendente);
	void update(Mese mese);
	void delete(Integer id_mese);
	Mese selectByMese(Date mese);
	List<Mese> selectAll();
	Integer selectLastID();
	List<Integer> selectAllID();

}
