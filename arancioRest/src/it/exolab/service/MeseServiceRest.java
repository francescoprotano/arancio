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

import it.exolab.connection.ConnectionMeseEJB;
import it.exolab.model.Mese;
import it.exolab.responces.RispostaMese;

@Path("/mese")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MeseServiceRest {
	
	@POST
	@Path("/add")
	public RispostaMese add(Mese mese) {
		return ConnectionMeseEJB.getConnection().add(mese);
	}
	
	@POST
	@Path("/update")
	public RispostaMese update(Mese mese) {
		return ConnectionMeseEJB.getConnection().edit(mese);
	}
	
	@GET
	@Path("/delete")
	public RispostaMese delete(@QueryParam("id_mese") Integer id_mese) {
		return ConnectionMeseEJB.getConnection().delete(id_mese);
	}
	
	@GET
	@Path("/selectByMese")
	public RispostaMese selectByMese(@QueryParam("mese") Date mese) {
		return ConnectionMeseEJB.getConnection().selectByMese(mese);
	}
	
	@GET
	@Path("/all")
	public List<Mese> selectAll(){
		return ConnectionMeseEJB.getConnection().allMesi();
	}

}
