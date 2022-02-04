package it.exolab.ejb;

import java.util.List;

import javax.ejb.Remote;

import it.exolab.exception.Risposta;
import it.exolab.model.Contratto;

@Remote
public interface ContrattoEJBRemote {
	
	public Risposta add(Contratto contratto);
	public Risposta edit(Contratto contratto);
	public Risposta delete(Integer id_contratto);
	public Risposta selectByID(Integer id_contratto);
	public Risposta selectByTipologia(String tipologia);
	public List<Contratto> allContratti();
}
