package it.exolab.mapper;

import java.util.List;

import it.exolab.model.DipendenteMese;

public interface DipendenteMeseMapper {
	
	void update(Integer id_dipendente_fk,Integer id_mese_fk);
	void delete(Integer id_dipendente_fk,Integer id_mese_fk);
	DipendenteMese selectOne(Integer id_dipendente_fk,Integer id_mese_fk);
	List<DipendenteMese> selectAll();
	List<DipendenteMese> selectByDipendente(Integer id_dipendente_fk);
	List<DipendenteMese> selectByMese(Integer id_mese_fk);
	List<DipendenteMese> selectByStato(Integer stato);
	List<DipendenteMese> allDipendentiJoinDipendentiMesiJoinMesiJoinPresenze(Integer id_dipendente_fk);

}
