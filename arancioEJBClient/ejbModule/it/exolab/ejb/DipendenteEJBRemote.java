package it.exolab.ejb;

import java.util.List;

import javax.ejb.Remote;

import it.exolab.model.Dipendente;

@Remote
public interface DipendenteEJBRemote {
	
	public void add(Dipendente dipendente);
	
	public void edit(Dipendente dipendente);
	
	public void delete(Integer id);
	
	public List<Dipendente> allDipendenti();
	
	public Dipendente selectByEmail(String email);
	
	
}
