package it.exolab.service;

import java.sql.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import it.exolab.connection.ConnectionPresenzaEJB;
import it.exolab.model.Presenza;
import it.exolab.responces.RispostaPresenza;
import it.exolab.responces.RispostaPresenze;

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
	public RispostaPresenza delete(Presenza presenza) {
		return ConnectionPresenzaEJB.getConnection().delete(presenza);
	}
	
	@GET
	@Path("/selectByData")
	public RispostaPresenze selectByData(@QueryParam("data") Date data) {
		return ConnectionPresenzaEJB.getConnection().selectByData(data);
	}
	
	@GET
	@Path("/selectByMese")
	public RispostaPresenze selectByMese(@QueryParam("id_mese_fk") Integer id_mese_fk) {
		return ConnectionPresenzaEJB.getConnection().selectByMese(id_mese_fk);
	}
	
	@GET
	@Path("/selectByDipendente")
	public RispostaPresenze selectByDipendente(@QueryParam("id_dipendente_fk") Integer id_dipendente_fk) {
		return ConnectionPresenzaEJB.getConnection().selectByDipendente(id_dipendente_fk);
	}
	
	@GET
	@Path("/selectByAssenza")
	public RispostaPresenze selectByAssenza(@QueryParam("motivazione_assenza_fk") String motivazione_assenza_fk) {
		return ConnectionPresenzaEJB.getConnection().selectByAssenza(motivazione_assenza_fk);
	}
	
	@GET
	@Path("/all")
	public RispostaPresenze selectAll(){
		return ConnectionPresenzaEJB.getConnection().selectAll();
	}

}
