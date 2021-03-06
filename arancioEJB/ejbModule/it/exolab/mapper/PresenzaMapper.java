package it.exolab.mapper;

import java.sql.Date;
import java.util.List;

import it.exolab.model.Dipendente;
import it.exolab.model.Presenza;

public interface PresenzaMapper {
	
	void insert(Presenza presenza);
	void update(Presenza presenza);
	void delete(Integer id_presenza);
	List<Presenza> selectByData(Date data);
	List<Presenza> selectByMese(Date data);
	List<Presenza> selectByDipendente(Integer id_dipendente_fk);
	List<Presenza> selectByAssenza(String motivazione_assenza_fk);
	List<Presenza> selectAll();
	List<Presenza> presenzeJoinmesi(Presenza p);
	Integer ricercaIdDelMese(Date data);
	Dipendente presenzeDelDipendenteDelMese(Presenza presenza);
	
}
