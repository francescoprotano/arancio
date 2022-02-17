import { formatDate } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Container } from '../models/container';
import { Dipendente } from '../models/dipendente';
import { DipendenteMese } from '../models/dipendenteMese';
import { Presenza } from '../models/presenza';

@Injectable({
  providedIn: 'root'
})
export class PresenzaService {
  private backendURL: String = "http://localhost:8080/arancioRest/gestione_presenze/presenza";
  private presenzaSelezionata: Presenza = new Presenza;
  user: any = sessionStorage.getItem("utente") || '{}';
  utenteLoggato: Dipendente = new Dipendente();
  dipendenteMese: DipendenteMese = new DipendenteMese();
  cont : Container = new Container();
  
  constructor(private http: HttpClient) {
    this.utenteLoggato = JSON.parse(sessionStorage.getItem("utente") || '{}');
    this.cont.pres.data = new Date();
  }


  public aggiornaPresenza(model: Presenza, onSuccess: any, onFailure: any) {
    this.cont.pres = model
    this.cont.dip = this.utenteLoggato
    return this.doPostX("/update", this.cont, onSuccess, onFailure);
  }

  public aggiornaStato(model: DipendenteMese, onSuccess: any, onFailure: any) {
    return this.doPost("/update", model, this.utenteLoggato, onSuccess, onFailure);
  }


  public elencoPresenze(onSuccess: any, onFailure: any) {
    this.doGet("/all", this.utenteLoggato, onSuccess, onFailure);
  }
  public elencoPresenzeIndividual(id_dipendente_fk: number, onSuccess: any, onFailure: any): void {
    this.doGet("/selectByDipendente?id_dipendente_fk=" + id_dipendente_fk, this.utenteLoggato, onSuccess, onFailure);
  }

 

  public aggiungiPresenza(model: Presenza, onSuccess: any, onFailure: any): void {
    this.doPost("/add", model, this.utenteLoggato, onSuccess, onFailure);
  }

  public elencoByMese(data: any, onSuccess: any, onFailure: any) {
    this.cont.pres.data = data
    this.cont.dip = this.utenteLoggato
    this.doPostX("/presenzeJoinMese", this.cont, onSuccess, onFailure)
  }

  private doGet(querystring: String, utenteLoggato: Dipendente, onSuccess: any, onFailure: any) {

    var url = this.backendURL + "" + querystring;

    return this.http.get(url).subscribe((httpResponse: any) => {
      this.presenzaSelezionata = httpResponse;
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
      console.log(httpResponse);
      console.log(data);

      if (httpResponse.successo == true) {
        onSuccess(httpResponse.data);
      } else {
        onFailure(httpResponse.codice_errore);
        alert("Operazione non andata a buon fine. Codice errore: " + httpResponse.codice_errore);

      }

    });

  }

  private doPostX(querystring: any, cont : Container, onSuccess: any, onFailure: any) {

    var url = this.backendURL + "" + querystring;



    return this.http.post(url, cont).subscribe((httpResponse: any) => {
      console.log(httpResponse);
      console.log(cont.dip);
      console.log(cont.pres);

      if (httpResponse.successo == true) {
        onSuccess(httpResponse.data);
      } else {
        onFailure(httpResponse.codice_errore);
        alert("Operazione non andata a buon fine. Codice errore: " + httpResponse.codice_errore);

      }

    });

  }
}
