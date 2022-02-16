package it.exolab.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.exolab.connection.ConnectionDipendenteMese;
import it.exolab.model.Dipendente;
import it.exolab.model.DipendenteMese;
import it.exolab.responces.RispostaDipendenteMese;
import it.exolab.responces.RispostaDipendentiMesi;

@Path("/dipendenteMese")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DipendenteMeseServiceRest {

	@POST
	@Path("/update")
	public RispostaDipendenteMese update(DipendenteMese dipendenteMese,Dipendente dipendente) {
		return ConnectionDipendenteMese.getConnection().update(dipendenteMese,dipendente);
	}

	@GET
	@Path("/delete")
	public RispostaDipendenteMese delete(DipendenteMese dipendenteMese,Dipendente dipendente) {
		return ConnectionDipendenteMese.getConnection().delete(dipendenteMese,dipendente);
	}

	@GET
	@Path("/selectOne")
	public RispostaDipendenteMese selectOne(DipendenteMese dipendenteMese,Dipendente dipendente) {
		return ConnectionDipendenteMese.getConnection().selectOne(dipendenteMese,dipendente);
	}

	@GET
	@Path("/selectAll")
	public RispostaDipendentiMesi selectAll(Dipendente dipendente) {
		return ConnectionDipendenteMese.getConnection().selectAll(dipendente);
	}

	@POST
	@Path("/selectByDipendente")
	public RispostaDipendentiMesi selectByDipendente(DipendenteMese dipendenteMese,Dipendente dipendente) {
		return ConnectionDipendenteMese.getConnection().selectByDipendente(dipendenteMese,dipendente);
	}

	@GET
	@Path("/selectByMese")
	public RispostaDipendentiMesi selectByMese(DipendenteMese dipendenteMese,Dipendente dipendente) {
		return ConnectionDipendenteMese.getConnection().selectByMese(dipendenteMese,dipendente);
	}

	@GET
	@Path("/selectByStato")
	public RispostaDipendentiMesi selectByStato(DipendenteMese dipendenteMese,Dipendente dipendente) {
		return ConnectionDipendenteMese.getConnection().selectByStato(dipendenteMese,dipendente);
	}

}
