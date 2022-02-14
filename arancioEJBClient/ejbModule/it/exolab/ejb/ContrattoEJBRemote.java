package it.exolab.ejb;

import java.util.List;

import javax.ejb.Remote;

import it.exolab.model.Contratto;
import it.exolab.responces.RispostaContratti;
import it.exolab.responces.RispostaContratto;

@Remote
public interface ContrattoEJBRemote {
	
	public RispostaContratto add(Contratto contratto);
	public RispostaContratto edit(Contratto contratto);
	public RispostaContratto delete(Contratto contratto);
	public RispostaContratto selectByID(Integer id_contratto);
	public RispostaContratti selectByTipologia(String tipologia);
	public RispostaContratti allContratti();
}
