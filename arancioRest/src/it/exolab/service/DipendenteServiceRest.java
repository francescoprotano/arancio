package it.exolab.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import it.exolab.connection.ConnectionDipendenteEJB;
import it.exolab.model.Dipendente;
import it.exolab.responces.RispostaDipendente;
import it.exolab.responces.RispostaDipendenti;

@Path("/dipendente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DipendenteServiceRest {

	// *** DIPENDENTI ***

	@POST
	@Path("/add")
	public RispostaDipendente add(Dipendente dipendente) {
		return ConnectionDipendenteEJB.getConnection().add(dipendente);
	}

	@POST
	@Path("/update")
	public RispostaDipendente update(Dipendente dipendente) {
		return ConnectionDipendenteEJB.getConnection().edit(dipendente);
	}

	@GET
	@Path("/delete")
	public RispostaDipendente delete(Dipendente dipendente) {
		return ConnectionDipendenteEJB.getConnection().delete(dipendente);
	}

	@POST
	@Path("/updatePassword")
	public RispostaDipendente updatePassword(Dipendente dipendente) {
		return ConnectionDipendenteEJB.getConnection().updatePassword(dipendente);
	}

	@POST
	@Path("/login")
	public RispostaDipendente login(Dipendente dipendente) {
		return ConnectionDipendenteEJB.getConnection().login(dipendente);
	}

	@GET
	@Path("/allByRuolo")
	public RispostaDipendenti allByRuolo(@QueryParam("ruolo_fk") String ruolo_fk) {
		return ConnectionDipendenteEJB.getConnection().selectByRuolo(ruolo_fk);
	}

	@GET
	@Path("/all")
	public RispostaDipendenti allDipendenti() {
		return ConnectionDipendenteEJB.getConnection().allDipendenti();
	}

	// *** JOIN ***

	@GET
	@Path("/allJoinDipendentiEContratti")
	public RispostaDipendenti allJoinDipendentiEContratti() {
		return ConnectionDipendenteEJB.getConnection().allJoinDipendentiEContratti();
	}

	@GET
	@Path("/allJoinDipendentiEPresenze")
	public RispostaDipendenti allJoinDipendentiEPresenze() {
		return ConnectionDipendenteEJB.getConnection().allJoinDipendentiEPresenze();
	}

}
