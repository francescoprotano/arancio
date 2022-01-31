package it.exolab.ejb;

import java.util.List;

import javax.ejb.Remote;

import it.exolab.model.Dipendente;

@Remote
public interface DipendenteEJBRemote {
	
	public void add(Dipendente dipendente);
	
	public void edit(int id);
	
	public void delete(int id);
	
	public List<Dipendente> allDipendenti();
	
}
