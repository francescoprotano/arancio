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

import it.exolab.connection.ConnectionDipendenteEJB;
import it.exolab.model.Dipendente;

@Path("/gestisci")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GestionePresenzeService {

	@POST
	@Path("/add")
	public void add(Dipendente model) {
		ConnectionDipendenteEJB.getConnection().add(model);
	}

	@GET
	@Path("/delete")
	public void delete(@QueryParam("codice") int id) {
		ConnectionDipendenteEJB.getConnection().delete(id);
	}

	@POST
	@Path("/update")
	public void update(Dipendente model) {
		ConnectionDipendenteEJB.getConnection().edit(model);
	}

	@GET
	@Path("/all")
	public List<Dipendente> allDipendenti() {
		return ConnectionDipendenteEJB.getConnection().allDipendenti();

	}

	@GET
	@Path("/allByEmail")
	public Dipendente allByEmail(@QueryParam("email") String email) {
		return ConnectionDipendenteEJB.getConnection().selectByEmail(email);

	}

}
