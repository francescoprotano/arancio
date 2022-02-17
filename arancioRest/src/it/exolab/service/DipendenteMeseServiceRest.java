package it.exolab.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.exolab.connection.ConnectionDipendenteMese;
import it.exolab.model.Container;
import it.exolab.model.Dipendente;
import it.exolab.responces.RispostaDipendenteMese;
import it.exolab.responces.RispostaDipendentiMesi;

@Path("/dipendenteMese")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DipendenteMeseServiceRest {

	@POST
	@Path("/update")
	public RispostaDipendenteMese update(Container cont) {
		return ConnectionDipendenteMese.getConnection().update(cont.getDipMes(),cont.getDip());
	}

	@POST
	@Path("/delete")
	public RispostaDipendenteMese delete(Container cont) {
		return ConnectionDipendenteMese.getConnection().delete(cont.getDipMes(),cont.getDip());
	}

	@POST
	@Path("/selectOne")
	public RispostaDipendenteMese selectOne(Container cont) {
		return ConnectionDipendenteMese.getConnection().selectOne(cont.getDipMes(),cont.getDip());
	}

	@POST
	@Path("/selectAll")
	public RispostaDipendentiMesi selectAll(Dipendente dipendente) {
		return ConnectionDipendenteMese.getConnection().selectAll(dipendente);
	}

	@POST
	@Path("/selectByDipendente")
	public RispostaDipendentiMesi selectByDipendente(Container cont) {
		return ConnectionDipendenteMese.getConnection().selectByDipendente(cont.getDipMes(),cont.getDip());
	}

	@POST
	@Path("/selectByMese")
	public RispostaDipendentiMesi selectByMese(Container cont) {
		return ConnectionDipendenteMese.getConnection().selectByMese(cont.getDipMes(),cont.getDip());
	}

	@POST
	@Path("/selectByStato")
	public RispostaDipendentiMesi selectByStato(Container cont) {
		return ConnectionDipendenteMese.getConnection().selectByStato(cont.getDipMes(),cont.getDip());
	}

}
