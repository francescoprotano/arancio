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
import it.exolab.exception.RispostaPresenza;
import it.exolab.model.Presenza;

@Path("/presenza")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PresenzaServiceRest {
	
	@POST
	@Path("/add")
	public RispostaPresenza add(Presenza presenza) {
	return ConnectionPresenzaEJB.getConnection().add(presenza);	
	}
	
	@POST
	@Path("/update")
	public RispostaPresenza update(Presenza presenza) {
		return ConnectionPresenzaEJB.getConnection().edit(presenza);
	}
	
	@DELETE
	public RispostaPresenza delete(@QueryParam("id_presenza") Integer id_presenza) {
		return ConnectionPresenzaEJB.getConnection().delete(id_presenza);
	}
	
	@GET
	@Path("/selectByData")
	public RispostaPresenza selectByData(@QueryParam("data") Date data) {
		return ConnectionPresenzaEJB.getConnection().selectByData(data);
	}
	
	@GET
	@Path("/selectByMese")
	public RispostaPresenza selectByMese(@QueryParam("id_mese_fk") Integer id_mese_fk) {
		return ConnectionPresenzaEJB.getConnection().selectByMese(id_mese_fk);
	}
	
	@GET
	@Path("/selectByDipendente")
	public RispostaPresenza selectByDipendente(@QueryParam("id_dipendente_fk") Integer id_dipendente_fk) {
		return ConnectionPresenzaEJB.getConnection().selectByDipendente(id_dipendente_fk);
	}
	
	@GET
	@Path("/selectByAssenza")
	public RispostaPresenza selectByAssenza(@QueryParam("motivazione_assenza_fk") String motivazione_assenza_fk) {
		return ConnectionPresenzaEJB.getConnection().selectByAssenza(motivazione_assenza_fk);
	}
	
	@GET
	@Path("/all")
	public List<Presenza> selectAll(){
		return ConnectionPresenzaEJB.getConnection().selectAll();
	}

}
