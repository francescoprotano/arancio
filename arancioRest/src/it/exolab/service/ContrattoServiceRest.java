package it.exolab.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import it.exolab.connection.ConnectionContrattoEJB;
import it.exolab.model.Contratto;
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
		public RispostaContratto add(Contratto contratto,Dipendente dipendente) {
			return ConnectionContrattoEJB.getConnection().add(contratto,dipendente);
		}
		
		@POST
		@Path("/updateContratto")
		public RispostaContratto update(Contratto contratto,Dipendente dipendente) {
			return ConnectionContrattoEJB.getConnection().edit(contratto,dipendente);
		}
		
		@GET
		@Path("/deleteContratto")
		public RispostaContratto deleteContratto(Contratto contratto,Dipendente dipendente) {
			return ConnectionContrattoEJB.getConnection().delete(contratto,dipendente);
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
