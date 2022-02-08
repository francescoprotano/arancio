import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Contratto } from '../models/contratto';
import { Dipendente } from '../models/dipendente';
import { Presenza } from '../models/presenza';

@Injectable({
  providedIn: 'root'
})
export class DipendenteService {
  private lavoratoreSelezionato: Dipendente = new Dipendente;
  private backendURL :String = "http://localhost:8080/arancioRest/gestione_presenze/dipendente";

  constructor(private http: HttpClient) { }

  
  //***DIPENDENTE***

  public aggiungi(model: Dipendente,onSuccess:any,onFailure:any) : void {
    this.doPost("/add",model,onSuccess,onFailure);
  }


  public elenco2(queryString : string){
    return this.http.get<Array<Dipendente>>(this.backendURL + queryString);
   }

   public selectByEmail(email: string,onSuccess:any,onFailure:any){
    return this.doGet("/allByEmail?email="+email,onSuccess,onFailure);
    
   }
 
   public elimina(codice:number,onSuccess:any,onFailure:any){
     return this.doGet("/delete?codice="+codice,onSuccess,onFailure);
   }

   public aggiorna(model: Dipendente,onSuccess:any,onFailure:any)  {
	  return this.doPost("/update",model, onSuccess,onFailure);
  }

  

  public aggiornaPassword(model: Dipendente,onSuccess:any,onFailure:any)  {
	  return this.doPost("/updatePassword?newPassword=", model, onSuccess,onFailure);
  }

  public cercaPerId(id_dipendente : number, onSuccess : any, onFailure : any){
    this.doGet("/findId?id_dipendente="+id_dipendente,onSuccess,onFailure);
  }

  

   private doGet(querystring:String,onSuccess:any,onFailure:any){
    
    var url = this.backendURL + "" +querystring;
  
      return this.http.get(url).subscribe((httpResponse:any) => {
        this.lavoratoreSelezionato = httpResponse;
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
