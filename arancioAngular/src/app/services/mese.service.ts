import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Dipendente } from '../models/dipendente';
import { Mese } from '../models/mese';

@Injectable({
  providedIn: 'root'
})
export class MeseService {
  private meseSelezionato: Mese = new Mese;
  private backendURL :String = "http://localhost:8080/arancioRest/gestione_presenze/mese";
  utenteLoggato: Dipendente = new Dipendente();
  constructor(private http: HttpClient) {
    this.utenteLoggato = JSON.parse(sessionStorage.getItem("utente") || '{}');
   }

  //***MESE***

public aggiungiMese(model: Dipendente,onSuccess:any,onFailure:any) : void {
  this.doPost("/add",model, this.utenteLoggato, onSuccess,onFailure);
}

public eliminaMese(id_mese:number,onSuccess:any,onFailure:any){
  return this.doGet("/delete?id_mese="+id_mese, this.utenteLoggato, onSuccess,onFailure);
}

public elencoMesi(onSuccess:any,onFailure:any){
  return this.doGet("/selectByDipendente", this.utenteLoggato, onSuccess,onFailure);;
 }

 public aggiornaMese(model: Mese,onSuccess:any,onFailure:any)  {
  return this.doPost("/update",model, this.utenteLoggato, onSuccess,onFailure);
}

public elencoByMese(day : string, onSuccess: any, onFailure: any ){
  this.doGet("/selectByMese?mese="+ day, this.utenteLoggato, onSuccess, onFailure)
}

private doGet(querystring:String,utenteLoggato:Dipendente,onSuccess:any,onFailure:any){
    
  var url = this.backendURL + "" +querystring;

    return this.http.get(url).subscribe((httpResponse:any) => {
      this.meseSelezionato = httpResponse;
              console.log(httpResponse);
    if(httpResponse.successo == true){
      
      onSuccess(httpResponse.data);
    } else {
      onFailure(httpResponse.codice_errore);
      
    }
    
                
    });
}

private doPost(querystring:any, data:any, utenteLoggato:Dipendente, onSuccess:any,onFailure:any){
  
  var url = this.backendURL + "" + querystring;



   return this.http.post(url,data).subscribe((httpResponse:any) => {
             console.log(httpResponse);
             console.log(data);
         
   if(httpResponse.successo == true){
     onSuccess(httpResponse.data);
   } else {
     onFailure(httpResponse.codice_errore);
     alert("Operazione non andata a buon fine. Codice errore: "+httpResponse.codice_errore);
     
   }       
               
   });
}


}
