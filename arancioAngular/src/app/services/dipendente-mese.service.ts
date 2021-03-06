import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Container } from '../models/container';
import { Dipendente } from '../models/dipendente';
import { DipendenteMese } from '../models/dipendenteMese';

@Injectable({
  providedIn: 'root'
})
export class DipendenteMeseService {
  private backendURL: String = "http://localhost:8080/arancioRest/gestione_presenze/dipendenteMese";
  utenteLoggato: Dipendente = new Dipendente();
  dipendenteMese: DipendenteMese = new DipendenteMese();
  cont : Container = new Container();
  constructor(private http: HttpClient) {
    this.utenteLoggato = JSON.parse(sessionStorage.getItem("utente") || '{}');
  }


  public elencoDipendentiMesi(onSuccess: any, onFailure: any) {
    this.doPost("/selectAll", this.utenteLoggato, onSuccess, onFailure);
  }

  public selectAll(dipendenteMese: DipendenteMese, onSuccess: any, onFailure: any): void {
    this.cont.dipMes = dipendenteMese;
    this.cont.dip = this.utenteLoggato;
    this.doPost("/selectByDipendente" , this.cont, onSuccess, onFailure);
  }

  public sendMonth(dipendenteMese: DipendenteMese, onSuccess: any, onFailure: any){
    this.cont.dipMes = dipendenteMese;
    this.cont.dip = this.utenteLoggato;
    this.doPost("/update" , this.cont, onSuccess, onFailure);
  }

  private doGet(querystring: String, utenteLoggato : Dipendente, onSuccess: any, onFailure: any) {

    var url = this.backendURL + "" + querystring;

    return this.http.get(url).subscribe((httpResponse: any) => {

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


      if (httpResponse.successo == true) {
        onSuccess(httpResponse.data);
      } else {
        onFailure(httpResponse.codice_errore);
        alert("Operazione non andata a buon fine. Codice errore: " + httpResponse.codice_errore);

      }

    });

  }

}
