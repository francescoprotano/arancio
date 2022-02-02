package it.exolab.ejb;

import java.util.List;

import javax.ejb.Remote;

import it.exolab.model.Contratto;


@Remote
public interface ContrattoEJBRemote {
public void add(Contratto contratto);
	
	public void edit(Contratto contratto);
	
	public void delete(int id);
	
	public List<Contratto> allContratti();
}
