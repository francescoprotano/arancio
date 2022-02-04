package it.exolab.ejb;

import java.util.List;

import javax.ejb.Remote;

import it.exolab.exception.Risposta;
import it.exolab.model.Dipendente;

@Remote
public interface DipendenteEJBRemote {
	
	public Risposta add(Dipendente dipendente);
	public Risposta edit(Dipendente dipendente);
	public Risposta delete(Integer id);
	public Risposta selectByEmail(String email);
	public List<Dipendente> allDipendenti();
	
}
