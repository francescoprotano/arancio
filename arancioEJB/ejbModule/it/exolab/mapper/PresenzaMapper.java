package it.exolab.mapper;

import java.util.List;

import it.exolab.model.Presenza;



public interface PresenzaMapper {
	void insert(Presenza model);
	void delete(int id);
	void update(Presenza model);
	List<Presenza> all();
}
