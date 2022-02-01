package it.exolab.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

	@POST
	@Path("/delete")
	public void delete(int id) {
		ConnectionDipendenteEJB.getConnection().delete(id);
	}

	@POST
	@Path("/update")
	public void update(int id) {
		ConnectionDipendenteEJB.getConnection().edit(id);
	}

	@GET
	@Path("/all")
	public List<Dipendente> allDipendenti() {
		return ConnectionDipendenteEJB.getConnection().allDipendenti();

	}

}
