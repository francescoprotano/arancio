import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Contratto } from '../models/contratto';
import { Dipendente } from '../models/dipendente';
import { Risposta } from '../models/risposta';

@Injectable({
  providedIn: 'root'
})
export class ContrattoService {
  private backendURL :String = "http://localhost:8080/arancioRest/gestione_presenze/contratto";
  private lavoratoreSelezionato: Dipendente = new Dipendente;
  risp : Array<Risposta> = new Array<Risposta>()
  constructor(private http: HttpClient) { }

//***CONTRATTO***

public aggiungiContratto(model: Contratto,onSuccess:any,onFailure:any) : void {
  this.doPost("/addContratto",model,onSuccess,onFailure);
}

public eliminaContratto(id_contratto:number,onSuccess:any,onFailure:any){
  return this.doGet("/deleteContratto?id_contratto="+id_contratto,onSuccess,onFailure);
}

public elencoContratti(onSuccess:any,onFailure:any){
  return this.doGet("/allContratti",onSuccess,onFailure);
 }

 public byTipologia(tipologia:string,onSuccess:any,onFailure:any){
  return this.doGet("/allByTipologia?tipologia="+tipologia,onSuccess,onFailure);
 }

 public aggiornaContratto(model: Contratto,onSuccess:any,onFailure:any)  {
  return this.doPost("/updateContratto",model, onSuccess,onFailure);
}

private doGetC(querystring:String,callback: any){
  var url = this.backendURL + "" +querystring;
    return this.http.get(url).subscribe((httpResponse:any) => {
              console.log("dogetc"+JSON.stringify(httpResponse));
              
    callback(httpResponse)         
    });
}

private doGet(querystring:String,onSuccess:any,onFailure:any){
    
  var url = this.backendURL + "" +querystring;

    return this.http.get(url).subscribe((httpResponse:any) => {
      this.lavoratoreSelezionato = httpResponse;
              console.log(httpResponse);
    if(httpResponse.successo == true){
      console.log(httpResponse.data);
      
      onSuccess(httpResponse);
    } else {
      onFailure(httpResponse);
      
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
