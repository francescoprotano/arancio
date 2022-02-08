import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Mese } from '../models/mese';

@Injectable({
  providedIn: 'root'
})
export class MeseService {
  private meseSelezionato: Mese = new Mese;
  private backendURL :String = "http://localhost:8080/arancioRest/gestione_presenze/mese";
  constructor(private http: HttpClient) { }

  //***MESE***

public aggiungiMese(model: Mese,onSuccess:any,onFailure:any) : void {
  this.doPost("/add",model,onSuccess,onFailure);
}

public eliminaMese(id_mese:number,onSuccess:any,onFailure:any){
  return this.doGet("/deleteMese?id_mese="+id_mese,onSuccess,onFailure);
}

public elencoMesi(queryString : string){
  return this.http.get<Array<Mese>>(this.backendURL + queryString);
 }

 public aggiornaMese(model: Mese,onSuccess:any,onFailure:any)  {
  return this.doPost("/update",model, onSuccess,onFailure);
}

private doGet(querystring:String,onSuccess:any,onFailure:any){
    
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
