import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Container } from '../models/container';
import { Contratto } from '../models/contratto';
import { Dipendente } from '../models/dipendente';
import { Presenza } from '../models/presenza';
import { UtenteLoggato } from '../models/utenteLoggato';

@Injectable({
  providedIn: 'root'
})
export class DipendenteService {
  private lavoratoreSelezionato: Dipendente = new Dipendente;
  private backendURL: String = "http://localhost:8080/arancioRest/gestione_presenze/dipendente";
  utenteLoggato: UtenteLoggato = new UtenteLoggato();
  cont: Container = new Container();
  constructor(private http: HttpClient) {
    this.utenteLoggato = JSON.parse(sessionStorage.getItem("utente") || '{}');
  }


  //***DIPENDENTE***

  public aggiungi(model: Dipendente, onSuccess: any, onFailure: any): void {
    this.cont.dip = model
    this.cont.utLog = this.utenteLoggato
    this.doPostAddUpdate("/add", this.cont, onSuccess, onFailure);
  }


  public elenco(onSuccess: any, onFailure: any) {
    return this.doPostElenco("/all", this.utenteLoggato, onSuccess, onFailure);
  }

  public elencoByContratto(onSuccess: any, onFailure: any) {
    return this.doPostElenco("/allJoinDipendentiEContratti", this.utenteLoggato, onSuccess, onFailure);
  }

  public selectByEmail(email: string, onSuccess: any, onFailure: any) {
    return this.doPostAddUpdate("/allByEmail?email=" + email, this.utenteLoggato, onSuccess, onFailure);
  }

  public elimina(codice: number, onSuccess: any, onFailure: any) {
    return this.doPostAddUpdate("/delete?codice=" + codice, this.utenteLoggato, onSuccess, onFailure);
  }

  public aggiorna(model: Dipendente, onSuccess: any, onFailure: any) {
    return this.doPostAddUpdate("/update", model,  onSuccess, onFailure);
  }



  public aggiornaPassword(model: Dipendente, onSuccess: any, onFailure: any) {
    return this.doPost("/updatePassword?newPassword=", model, this.utenteLoggato, onSuccess, onFailure);
  }

  public cercaPerId(id_dipendente: number, onSuccess: any, onFailure: any) {
    this.doPostAddUpdate("/findId?id_dipendente=" + id_dipendente, this.utenteLoggato, onSuccess, onFailure);
  }



  private doGet(querystring: String, utenteLoggato: Dipendente, onSuccess: any, onFailure: any) {

    var url = this.backendURL + "" + querystring;

    return this.http.get(url).subscribe((httpResponse: any) => {
      this.lavoratoreSelezionato = httpResponse;
      console.log(httpResponse);
      if (httpResponse.successo == true) {

        onSuccess(httpResponse.data);
      } else {
        onFailure(httpResponse.codice_errore);

      }


    });
  }

  private doPost(querystring: any, data: any, utenteLoggato: any, onSuccess: any, onFailure: any) {

    var url = this.backendURL + "" + querystring;



    return this.http.post(url, data, utenteLoggato).subscribe((httpResponse: any) => {


      if (httpResponse.successo == true) {
        console.log(httpResponse.data)
        onSuccess(httpResponse.data);
      } else {
        onFailure(httpResponse.codice_errore);
        alert("Operazione non andata a buon fine. Codice errore: " + httpResponse.codice_errore);

      }

    });
  }
  private doPostElenco(querystring: any, utenteLoggato: any, onSuccess: any, onFailure: any) {

    var url = this.backendURL + "" + querystring;



    return this.http.post(url, utenteLoggato).subscribe((httpResponse: any) => {
      console.log(httpResponse);


      if (httpResponse.successo == true) {
        onSuccess(httpResponse.data);
      } else {
        onFailure(httpResponse.codice_errore);
        alert("Operazione non andata a buon fine. Codice errore: " + httpResponse.codice_errore);

      }

    });
  }

  private doPostAddUpdate(querystring: any, model: any, onSuccess: any, onFailure: any) {

    var url = this.backendURL + "" + querystring;



    return this.http.post(url, model).subscribe((httpResponse: any) => {
      console.log(httpResponse);


      if (httpResponse.successo == true) {
        onSuccess(httpResponse.data);
      } else {
        onFailure(httpResponse.codice_errore);
        alert("Operazione non andata a buon fine. Codice errore: " + httpResponse.codice_errore);

      }

    });
  }

}
