package it.exolab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.exolab.entity.Dipendenti;

public interface DipendenteRepository extends CrudRepository<Dipendenti, Integer> {
	List<Dipendenti> cercaPerIdCheIniziaPer(Integer id_dipendente);
	
	@Query("SELECT u FROM Dipendenti u WHERE u.nome like %:nomeOCognome% or u.cognome like %:nomeOCognome%")
	List<Dipendenti> cercaPerNomeOCognome(@Param("nomeOCognome") String nomeOCognome);
	
	/*
	@Query("SELECT d FROM Dipendenti d JOIN FETCH d.contratto WHERE d.id_dipendente = ?1")
	Dipendenti cercaPerIdJoinContratto(Integer id_dipendente);
	*/
}
