package it.exolab.ejb;

import java.util.List;

import javax.ejb.Remote;

import it.exolab.exception.RispostaContratto;
import it.exolab.model.Contratto;

@Remote
public interface ContrattoEJBRemote {
	
	public RispostaContratto add(Contratto contratto);
	public RispostaContratto edit(Contratto contratto);
	public RispostaContratto delete(Integer id_contratto);
	public RispostaContratto selectByID(Integer id_contratto);
	public List<Contratto> selectByTipologia(String tipologia);
	public List<Contratto> allContratti();
}
