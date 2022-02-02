package it.exolab.ejb;

import java.util.List;

import javax.ejb.Remote;

import it.exolab.model.Presenza;


@Remote
public interface PresenzaEJBRemote {
public void add(Presenza presenza);
	
	public void edit(Presenza presenza);
	
	public void delete(int id);
	
	public List<Presenza> allPresenze();
}
