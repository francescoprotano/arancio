package it.exolab.mapper;

import java.sql.Date;
import java.util.List;

import it.exolab.model.Dipendente;
import it.exolab.model.DipendenteMese;
import it.exolab.model.Mese;
import it.exolab.model.Presenza;

public interface MeseMapper {
	
	void insert(Mese mese);
	void inserisciDipendenti_Mesi(DipendenteMese dipMes);
	void inserisciPresenzeMese(Presenza presenza);
	void update(Mese mese);
	void delete(Integer id_mese);
	Mese selectByMese(Date mese);
	List<Mese> selectAll();
	Integer selectLastID();
	List<Dipendente> selectAllID();

}
