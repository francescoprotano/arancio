package it.exolab.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import it.exolab.connection.ConnectionContrattoEJB;
import it.exolab.connection.ConnectionDipendenteEJB;
import it.exolab.exception.Risposta;
import it.exolab.model.Contratto;
import it.exolab.model.Dipendente;

@Path("/gestisci")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GestionePresenzeService {

	// *** DIPENDENTI ***
	
	@POST
	@Path("/add")
	public Risposta add(Dipendente dipendente) {
		return ConnectionDipendenteEJB.getConnection().add(dipendente);
	}

	@POST
	@Path("/update")
	public Risposta update(Dipendente dipendente) {
		return ConnectionDipendenteEJB.getConnection().edit(dipendente);
	}
	
	@GET
	@Path("/delete")
	public Risposta delete(@QueryParam("codice") Integer id_dipendente) {
		return ConnectionDipendenteEJB.getConnection().delete(id_dipendente);
	}

	@GET
	@Path("/allByEmail")
	public Risposta allByEmail(@QueryParam("email") String email) {
		return ConnectionDipendenteEJB.getConnection().selectByEmail(email);
	}
	
	@GET
	@Path("/allByRuolo")
	public Risposta allByRuolo(@QueryParam("ruolo") String ruolo) {
		return ConnectionDipendenteEJB.getConnection().selectByRuolo(ruolo);
	}

	@GET
	@Path("/all")
	public List<Dipendente> allDipendenti() {
		return ConnectionDipendenteEJB.getConnection().allDipendenti();
	}
	
	// *** CONTRATTI ***
	
	@GET
	@Path("/allContratti")
	public List<Contratto> allContratti() {
		return ConnectionContrattoEJB.getConnection().allContratti();
	}
	
	@POST
	@Path("/addContratto")
	public Risposta add(Contratto contratto) {
		return ConnectionContrattoEJB.getConnection().add(contratto);
	}
	
	@POST
	@Path("/updateContratto")
	public Risposta update(Contratto contratto) {
		return ConnectionContrattoEJB.getConnection().edit(contratto);
	}
	
	@GET
	@Path("/deleteContratto")
	public Risposta deleteContratto(@QueryParam("id_contratto") Integer id_contratto) {
		return ConnectionContrattoEJB.getConnection().delete(id_contratto);
	}
	
	@GET
	@Path("/allById")
	public Risposta allContrattiById(@QueryParam("id_contratto") Integer id_contratto) {
		return ConnectionContrattoEJB.getConnection().selectByID(id_contratto);
	}
	
	@GET
	@Path("/allByTipologia")
	public Risposta allContrattiByTipologia(@QueryParam("tipologia") String tipologia) {
		return ConnectionContrattoEJB.getConnection().selectByTipologia(tipologia);
	}
	
	// *** JOIN ***
	
	@GET
	@Path("/allJoinDipendentiEContratti")
	public List<Dipendente> allJoinDipendentiEContratti() {
		return ConnectionDipendenteEJB.getConnection().allJoinDipendentiEContratti();
	}
	

}
