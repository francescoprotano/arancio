package it.exolab.service;

import java.sql.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import it.exolab.connection.ConnectionPresenzaEJB;
import it.exolab.exception.Risposta;
import it.exolab.model.Presenza;

@Path("/presenza")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PresenzaServiceRest {
	
	@POST
	public Risposta add(Presenza presenza) {
	return ConnectionPresenzaEJB.getConnection().add(presenza);	
	}
	
	@PUT
	public Risposta update(Presenza presenza) {
		return ConnectionPresenzaEJB.getConnection().edit(presenza);
	}
	
	@DELETE
	public Risposta delete(@QueryParam("") Integer id_mese) {
		return ConnectionPresenzaEJB.getConnection().delete(id_mese);
	}
	
	@GET
	@Path("/selectByData")
	public Risposta selectByData(@QueryParam("") Date data) {
		return ConnectionPresenzaEJB.getConnection().selectByData(data);
	}
	
	@GET
	@Path("/selectByMese")
	public Risposta selectByMese(@QueryParam("") Integer id_mese_fk) {
		return ConnectionPresenzaEJB.getConnection().selectByMese(id_mese_fk);
	}
	
	@GET
	@Path("/selectByDipendente")
	public Risposta selectByDipendente(@QueryParam("") Integer id_dipendente_fk) {
		return ConnectionPresenzaEJB.getConnection().selectByDipendente(id_dipendente_fk);
	}
	
	@GET
	@Path("/selectByAssenza")
	public Risposta selectByAssenza(@QueryParam("") String motivazione_assenza_fk) {
		return ConnectionPresenzaEJB.getConnection().selectByAssenza(motivazione_assenza_fk);
	}
	
	@GET
	@Path("/all")
	public List<Presenza> selectAll(){
		return ConnectionPresenzaEJB.getConnection().selectAll();
	}

}
