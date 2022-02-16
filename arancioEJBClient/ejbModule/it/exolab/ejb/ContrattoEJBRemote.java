package it.exolab.ejb;

import java.util.List;

import javax.ejb.Remote;

import it.exolab.model.Contratto;
import it.exolab.model.Dipendente;
import it.exolab.responces.RispostaContratti;
import it.exolab.responces.RispostaContratto;

@Remote
public interface ContrattoEJBRemote {
	
	public RispostaContratto add(Contratto contratto,Dipendente dipendente);
	public RispostaContratto edit(Contratto contratto,Dipendente dipendente);
	public RispostaContratto delete(Contratto contratto,Dipendente dipendente);
	public RispostaContratto selectByID(Integer id_contratto,Dipendente dipendente);
	public RispostaContratti selectByTipologia(String tipologia,Dipendente dipendente);
	public RispostaContratti allContratti(Dipendente dipendente);
}
