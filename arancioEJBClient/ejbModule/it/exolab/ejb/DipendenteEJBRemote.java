package it.exolab.ejb;

import java.util.List;

import javax.ejb.Remote;

import it.exolab.exception.RispostaDipendente;
import it.exolab.model.Dipendente;

@Remote
public interface DipendenteEJBRemote {
	
	public RispostaDipendente add(Dipendente dipendente);
	public RispostaDipendente edit(Dipendente dipendente);
	public RispostaDipendente delete(Integer id_dipendente);
	public RispostaDipendente updatePassword(Dipendente dipendente);
	public RispostaDipendente selectByEmail(String email);
	public RispostaDipendente selectByRuolo(String ruolo);
	public List<Dipendente> allDipendenti();
	public List<Dipendente> allJoinDipendentiEContratti();
	public List<Dipendente> allJoinDipendentiEPresenze();
	
}
