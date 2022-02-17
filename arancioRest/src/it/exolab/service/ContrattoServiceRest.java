package it.exolab.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import it.exolab.connection.ConnectionContrattoEJB;
import it.exolab.model.Container;
import it.exolab.model.Dipendente;
import it.exolab.responces.RispostaContratti;
import it.exolab.responces.RispostaContratto;

@Path("/contratto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContrattoServiceRest {
	// *** CONTRATTI ***
	
		@GET
		@Path("/allContratti")
		public RispostaContratti allContratti(Dipendente dipendente) {
			return ConnectionContrattoEJB.getConnection().allContratti(dipendente);
		}
		
		@POST
		@Path("/addContratto")
		public RispostaContratto add(Container cont) {
			return ConnectionContrattoEJB.getConnection().add(cont.getCon(),cont.getDip());
		}
		
		@POST
		@Path("/updateContratto")
		public RispostaContratto update(Container cont) {
			return ConnectionContrattoEJB.getConnection().edit(cont.getCon(),cont.getDip());
		}
		
		@POST
		@Path("/deleteContratto")
		public RispostaContratto deleteContratto(Container cont) {
			return ConnectionContrattoEJB.getConnection().delete(cont.getCon(),cont.getDip());
		}
		
		@GET
		@Path("/allById")
		public RispostaContratto allContrattiById(@QueryParam("id_contratto") Integer id_contratto,Dipendente dipendente) {
			return ConnectionContrattoEJB.getConnection().selectByID(id_contratto,dipendente);
		}
		
		@GET
		@Path("/allByTipologia")
		public RispostaContratti allContrattiByTipologia(@QueryParam("tipologia") String tipologia,Dipendente dipendente) {
			return ConnectionContrattoEJB.getConnection().selectByTipologia(tipologia,dipendente);
		}

}
