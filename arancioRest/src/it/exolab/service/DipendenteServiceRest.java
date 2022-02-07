package it.exolab.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import it.exolab.connection.ConnectionDipendenteEJB;
import it.exolab.exception.Risposta;
import it.exolab.model.Dipendente;

@Path("/dipendente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DipendenteServiceRest {

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
	
	@POST
	@Path("/updatePassword")
	public Risposta updatePassword(Dipendente dipendente) {
		return ConnectionDipendenteEJB.getConnection().updatePassword(dipendente);
	}

	@GET
	@Path("/allByEmail")
	public Risposta allByEmail(@QueryParam("email") String email) {
		return ConnectionDipendenteEJB.getConnection().selectByEmail(email);
	}
	
	@GET
	@Path("/allByRuolo")
	public Risposta allByRuolo(@QueryParam("ruolo_fk") String ruolo_fk) {
		return ConnectionDipendenteEJB.getConnection().selectByRuolo(ruolo_fk);
	}

	@GET
	@Path("/all")
	public List<Dipendente> allDipendenti() {
		return ConnectionDipendenteEJB.getConnection().allDipendenti();
	}
	
	// *** JOIN ***
	
	@GET
	@Path("/allJoinDipendentiEContratti")
	public List<Dipendente> allJoinDipendentiEContratti() {
		return ConnectionDipendenteEJB.getConnection().allJoinDipendentiEContratti();
	}
	
	@GET
	@Path("/allJoinDipendentiEPresenze")
	public List<Dipendente> allJoinDipendentiEPresenze() {
		return ConnectionDipendenteEJB.getConnection().allJoinDipendentiEPresenze();
	}
	
}