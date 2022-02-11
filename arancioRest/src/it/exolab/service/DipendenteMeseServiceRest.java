package it.exolab.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.exolab.connection.ConnectionDipendenteMese;
import it.exolab.model.DipendenteMese;
import it.exolab.responces.RispostaDipendenteMese;

@Path("/dipendenteMese")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DipendenteMeseServiceRest {

	@POST
	@Path("/update")
	public RispostaDipendenteMese update(DipendenteMese dipendenteMese) {
		return ConnectionDipendenteMese.getConnection().update(dipendenteMese);
	}

	@GET
	@Path("/delete")
	public RispostaDipendenteMese delete(DipendenteMese dipendenteMese) {
		return ConnectionDipendenteMese.getConnection().delete(dipendenteMese);
	}

	@GET
	@Path("/selectOne")
	public RispostaDipendenteMese selectOne(DipendenteMese dipendenteMese) {
		return ConnectionDipendenteMese.getConnection().selectOne(dipendenteMese);
	}

	@GET
	@Path("/selectAll")
	public RispostaDipendenteMese selectAll() {
		return ConnectionDipendenteMese.getConnection().selectAll();
	}

	@GET
	@Path("/selectByDipendente")
	public RispostaDipendenteMese selectByDipendente(DipendenteMese dipendenteMese) {
		return ConnectionDipendenteMese.getConnection().selectByDipendente(dipendenteMese);
	}

	@GET
	@Path("/selectByMese")
	public RispostaDipendenteMese selectByMese(DipendenteMese dipendenteMese) {
		return ConnectionDipendenteMese.getConnection().selectByMese(dipendenteMese);
	}

	@GET
	@Path("/selectByStato")
	public RispostaDipendenteMese selectByStato(DipendenteMese dipendenteMese) {
		return ConnectionDipendenteMese.getConnection().selectByStato(dipendenteMese);
	}

}
