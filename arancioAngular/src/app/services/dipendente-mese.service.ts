import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DipendenteMeseService {
  private backendURL: String = "http://localhost:8080/arancioRest/gestione_presenze/dipendenteMese";
  constructor(private http: HttpClient) { }


  public elencoDipendentiMesi(onSuccess: any, onFailure: any) {
    this.doGet("/selectAll", onSuccess, onFailure);
  }


  private doGet(querystring: String, onSuccess: any, onFailure: any) {

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
  
}
