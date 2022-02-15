import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Presenza } from '../models/presenza';

@Injectable({
  providedIn: 'root'
})
export class PresenzaService {
  private backendURL: String = "http://localhost:8080/arancioRest/gestione_presenze/presenza";
  private presenzaSelezionata: Presenza = new Presenza;
  user: any = sessionStorage.getItem("utente") || '{}';
  constructor(private http: HttpClient) { }


  public aggiornaPresenza(model: Presenza, onSuccess: any, onFailure: any) {
    return this.doPost("/update", model, onSuccess, onFailure);
  }
  public elencoPresenze(onSuccess: any, onFailure: any) {
    this.doGet("/all", onSuccess, onFailure);
  }
  public elencoPresenzeIndividual(id_dipendente_fk: number, onSuccess: any, onFailure: any): void {
    this.doGet("/selectByDipendente?id_dipendente_fk=" + id_dipendente_fk, onSuccess, onFailure);
  }
  public aggiungiPresenza(model: Presenza, onSuccess: any, onFailure: any): void {
    this.doPost("/add", model, onSuccess, onFailure);
  }

  public elencoByMese(day : string, onSuccess: any, onFailure: any ){
    this.doGet("/presenzeJoinMese?data="+ day, onSuccess, onFailure)
  }

  private doGet(querystring: String, onSuccess: any, onFailure: any) {

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

  private doPost(querystring: any, data: any, onSuccess: any, onFailure: any) {

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
}
