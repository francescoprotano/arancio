import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Contratto } from '../models/contratto';
import { Dipendente } from '../models/dipendente';
import { Risposta } from '../models/risposta';

@Injectable({
  providedIn: 'root'
})
export class ContrattoService {
  private backendURL: String = "http://localhost:8080/arancioRest/gestione_presenze/contratto";
  private lavoratoreSelezionato: Dipendente = new Dipendente;
  risp: Array<Risposta> = new Array<Risposta>()
  utenteLoggato: Dipendente = new Dipendente();
  constructor(private http: HttpClient) {
    this.utenteLoggato = JSON.parse(sessionStorage.getItem("utente") || '{}');
  }

  //***CONTRATTO***

  public aggiungiContratto(model: Contratto, onSuccess: any, onFailure: any): void {
    this.doPost("/addContratto", model, this.utenteLoggato, onSuccess, onFailure);
  }

  public eliminaContratto(id_contratto: number, onSuccess: any, onFailure: any) {
    return this.doGet("/deleteContratto?id_contratto=" + id_contratto, this.utenteLoggato, onSuccess, onFailure);
  }

  public elencoContratti(onSuccess: any, onFailure: any) {
    return this.doPostRafforzato("/allContratti", this.utenteLoggato, onSuccess, onFailure);
  }

  public byTipologia(tipologia: string, onSuccess: any, onFailure: any) {
    return this.doPostRafforzato("/allByTipologia?tipologia=" + tipologia, this.utenteLoggato, onSuccess, onFailure);
  }

  public aggiornaContratto(model: Contratto, onSuccess: any, onFailure: any) {
    return this.doPost("/updateContratto", model, this.utenteLoggato, onSuccess, onFailure);
  }


  private doGet(querystring: String, utenteLoggato: Dipendente, onSuccess: any, onFailure: any) {

    var url = this.backendURL + "" + querystring;

    return this.http.get(url).subscribe((httpResponse: any) => {
      this.lavoratoreSelezionato = httpResponse;
      console.log(httpResponse);
      if (httpResponse.successo == true) {
        console.log(httpResponse.data);

        onSuccess(httpResponse);
      } else {
        onFailure(httpResponse);

      }


    });
  }

  private doPost(querystring: any, data: any, utenteLoggato: Dipendente, onSuccess: any, onFailure: any) {

    var url = this.backendURL + "" + querystring;



    return this.http.post(url, data).subscribe((httpResponse: any) => {
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

  private doPostRafforzato(querystring: any, utenteLoggato: any, onSuccess: any, onFailure: any) {

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
}
