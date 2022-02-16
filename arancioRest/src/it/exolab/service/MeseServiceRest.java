package it.exolab.service;

import java.sql.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import it.exolab.connection.ConnectionMeseEJB;
import it.exolab.model.Dipendente;
import it.exolab.model.Mese;
import it.exolab.responces.RispostaMese;
import it.exolab.responces.RispostaMesi;

@Path("/mese")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MeseServiceRest {
	
	@POST
	@Path("/add")
	public RispostaMese add(Dipendente dipendente) {
		return ConnectionMeseEJB.getConnection().add(dipendente);
	}
	
	@POST
	@Path("/update")
	public RispostaMese update(Mese mese,Dipendente dipendente) {
		return ConnectionMeseEJB.getConnection().edit(mese,dipendente);
	}
	
	@GET
	@Path("/delete")
	public RispostaMese delete(Mese mese,Dipendente dipendente) {
		return ConnectionMeseEJB.getConnection().delete(mese,dipendente);
	}
	
	@GET
	@Path("/selectByMese")
	public RispostaMese selectByMese(@QueryParam("mese") Date mese,Dipendente dipendente) {
		System.out.println(mese);
		return ConnectionMeseEJB.getConnection().selectByMese(mese,dipendente);
	}
	
	@GET
	@Path("/all")
	public RispostaMesi selectAll(Dipendente dipendente){
		return ConnectionMeseEJB.getConnection().allMesi(dipendente);
	}

}
