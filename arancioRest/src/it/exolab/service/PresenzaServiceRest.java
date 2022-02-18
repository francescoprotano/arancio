package it.exolab.service;

import java.sql.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import it.exolab.connection.ConnectionPresenzaEJB;
import it.exolab.model.Container;
import it.exolab.model.Dipendente;
import it.exolab.responces.RispostaDipendente;
import it.exolab.responces.RispostaPresenza;
import it.exolab.responces.RispostaPresenze;

@Path("/presenza")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PresenzaServiceRest {

	@POST
	@Path("/add")
	public RispostaPresenza add(Container cont) {
		return ConnectionPresenzaEJB.getConnection().add(cont.getPres(), cont.getDip());
	}

	@POST
	@Path("/update")
	public RispostaPresenza update(Container cont) {
		return ConnectionPresenzaEJB.getConnection().edit(cont.getPres(), cont.getDip());
	}

	@POST
	@Path("/delete")
	public RispostaPresenza delete(Container cont) {
		return ConnectionPresenzaEJB.getConnection().delete(cont.getPres(), cont.getDip());
	}

	@POST
	@Path("/selectByData")
	public RispostaPresenze selectByData(@QueryParam("data") Date data, Dipendente dipendente) {
		return ConnectionPresenzaEJB.getConnection().selectByData(data, dipendente);
	}

	@POST
	@Path("/selectByMese")
	public RispostaPresenze selectByMese(Container cont) {
		return ConnectionPresenzaEJB.getConnection().selectByMese(cont.getPres().getData(), cont.getDip());
	}

	@POST
	@Path("/selectByDipendente")
	public RispostaPresenze selectByDipendente(@QueryParam("id_dipendente_fk") Integer id_dipendente_fk,
			Dipendente dipendente) {
		return ConnectionPresenzaEJB.getConnection().selectByDipendente(id_dipendente_fk, dipendente);
	}

	@POST
	@Path("/selectByAssenza")
	public RispostaPresenze selectByAssenza(@QueryParam("motivazione_assenza_fk") String motivazione_assenza_fk,
			Dipendente dipendente) {
		return ConnectionPresenzaEJB.getConnection().selectByAssenza(motivazione_assenza_fk, dipendente);
	}

	@POST
	@Path("/all")
	public RispostaPresenze selectAll(Dipendente dipendente) {
		return ConnectionPresenzaEJB.getConnection().selectAll(dipendente);
	}

	@POST
	@Path("/presenzeJoinMese")
	public RispostaPresenze presenzeJoinMese(Container cont) {
		return ConnectionPresenzaEJB.getConnection().presenzeJoinmesi(cont.getPres().getData(), cont.getDip());
	}
	
	@POST
	@Path("/presenzeDelDipendenteDelMese")
	public RispostaDipendente presenzeDelDipendenteDelMese(Container cont) {
		return ConnectionPresenzaEJB.getConnection().presenzeDelDipendenteDelMese(cont.getPres(), cont.getDip());
	}
	
}
