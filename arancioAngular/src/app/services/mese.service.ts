import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Container } from '../models/container';
import { Dipendente } from '../models/dipendente';
import { Mese } from '../models/mese';

@Injectable({
  providedIn: 'root'
})
export class MeseService {
  private meseSelezionato: Mese = new Mese;
  private backendURL :String = "http://localhost:8080/arancioRest/gestione_presenze/mese";
  utenteLoggato: Dipendente = new Dipendente();
  cont: Container = new Container();
  constructor(private http: HttpClient) {
    this.utenteLoggato = JSON.parse(sessionStorage.getItem("utente") || '{}');
   }

  //***MESE***

public aggiungiMese(model: Dipendente,onSuccess:any,onFailure:any) : void {
  this.doPost("/add", this.utenteLoggato, onSuccess,onFailure);
}

public eliminaMese(mese:Mese,onSuccess:any,onFailure:any){
  this.cont.mese = mese;
  this.cont.dip = this.utenteLoggato;
  return this.doPost("/delete", this.cont,  onSuccess,onFailure);
}

public elencoMesi(onSuccess:any,onFailure:any){
  return this.doPost("/all", this.utenteLoggato, onSuccess,onFailure);;
 }

 public aggiornaMese(model: Mese,onSuccess:any,onFailure:any)  {
  return this.doPostContainer("/update", this.cont, onSuccess,onFailure);
}

public elencoByMese(day : string, onSuccess: any, onFailure: any ){
 return this.doPost("/selectByMese?mese="+ day, this.utenteLoggato, onSuccess, onFailure)
}

private doGet(querystring:String,onSuccess:any,onFailure:any){
    
  var url = this.backendURL + "" +querystring+""+this.utenteLoggato;
console.log("url: "+url)
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

private doPostContainer(querystring: any, cont : Container, onSuccess: any, onFailure: any){
  
  var url = this.backendURL + "" + querystring;



   return this.http.post(url,cont).subscribe((httpResponse:any) => {
             console.log(httpResponse);
             console.log(cont);
         
   if(httpResponse.successo == true){
     onSuccess(httpResponse.data);
   } else {
     onFailure(httpResponse.codice_errore);
     alert("Operazione non andata a buon fine. Codice errore: "+httpResponse.codice_errore);
     
   }       
               
   });
}

private doPost(querystring:any, data:any, onSuccess:any,onFailure:any){
  
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
