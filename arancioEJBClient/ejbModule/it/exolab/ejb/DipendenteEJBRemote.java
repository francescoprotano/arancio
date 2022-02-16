package it.exolab.ejb;

import javax.ejb.Remote;

import it.exolab.model.Dipendente;
import it.exolab.responces.RispostaDipendente;
import it.exolab.responces.RispostaDipendenti;

@Remote
public interface DipendenteEJBRemote {
	
	public RispostaDipendente add(Dipendente dipendente);
	public RispostaDipendente edit(Dipendente dipendente);
	public RispostaDipendente delete(Dipendente dipendente);
	
	public RispostaDipendente updatePassword(Dipendente dipendente);
	public RispostaDipendente login(Dipendente dipendente);
	public RispostaDipendenti selectByRuolo(String ruolo,Dipendente dipendente);
	
	public RispostaDipendenti allDipendenti(Dipendente dipendente);
	public RispostaDipendenti allJoinDipendentiEContratti(Dipendente dipendente);
	public RispostaDipendenti allJoinDipendentiEPresenze(Dipendente dipendente);
	
}
