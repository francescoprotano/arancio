package it.exolab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.exolab.entity.Contratti;
import it.exolab.repository.ContrattoRepository;


public class ContrattoService {
private ContrattoRepository contrattoRepository;
	
	@Autowired(required=true)
	public void setContrattoRepository(ContrattoRepository contrattoRepository) {
		this.contrattoRepository=contrattoRepository;
	}

	
	public void insert(Contratti model) {
		contrattoRepository.save(model);
		
		
	}

	
	public void update(Contratti model) {
		contrattoRepository.save(model);
		
	}

	
	public void delete(Integer id) {
		contrattoRepository.delete(id);
		
	}

	
	public Contratti find(Integer id) {
		return contrattoRepository.findOne(id);
	}

	
	public List<Contratti> all() {
		return (List<Contratti>)contrattoRepository.findAll();
	}
}
