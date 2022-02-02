package it.exolab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.entity.Dipendenti;
import it.exolab.repository.DipendenteRepository;

public class DipendenteService {
	private DipendenteRepository dipendenteRepository;

	@Autowired(required = true)
	public void setDipendenteRepository(DipendenteRepository dipendenteRepository) {
		this.dipendenteRepository = dipendenteRepository;
	}

	public void insert(Dipendenti model) {
		dipendenteRepository.save(model);

	}

	public void update(Dipendenti model) {
		dipendenteRepository.save(model);

	}

	public void delete(Integer id_dipendente) {
		dipendenteRepository.delete(id_dipendente);

	}
/*
	public Dipendenti cercaPerIdJoinContratto(Integer id_dipendente) {
		return dipendenteRepository.cercaPerIdJoinContratto(id_dipendente);
	}
*/
	public Dipendenti find(Integer id_dipendente) {
		return dipendenteRepository.findOne(id_dipendente);
	}

	public List<Dipendenti> all() {
		return (List<Dipendenti>) dipendenteRepository.findAll();
	}

	public List<Dipendenti> cercaPerIdCheIniziaPer(Integer q) {
		return (List<Dipendenti>) dipendenteRepository.cercaPerIdCheIniziaPer(q);
	}
}
