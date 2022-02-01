import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Dipendente } from '../models/dipendente';

@Injectable({
  providedIn: 'root'
})
export class DipendenteService {
  private listaDipendenti : Array<Dipendente> = new Array<Dipendente>();

  private backendURL :String = "http://localhost:8080/arancioRest/gestione_presenze/gestisci";

  constructor(private http: HttpClient) { }


  public aggiungi(model: Dipendente,onSuccess:any,onFailure:any) : void {
	  this.listaDipendenti.push(model);
    this.doPost("/add",model,onSuccess,onFailure);
  }


  public elenco2(queryString : string){
    return this.http.get<Array<Dipendente>>(this.backendURL + queryString);
   }
 
   public elimina(codice:number,onSuccess:any,onFailure:any){
     return this.doGet("/delete?codice="+codice,onSuccess,onFailure);
   }

   public aggiorna(model: Dipendente,onSuccess:any,onFailure:any)  {
	  return this.doPost("/update",model, onSuccess,onFailure);
  }

  public cercaPerId(id_dipendente : number, onSuccess : any, onFailure : any){
    this.doGet("/findId?id_dipendente="+id_dipendente,onSuccess,onFailure);
  }

  doPut(params: any, onSuccess: any, onFailure: any) {
    var url = this.backendURL + "/update";



     return this.http.put(url,params).subscribe((httpResponse:any) => {
               console.log(httpResponse);
               console.log(params);
     if(httpResponse.success){
       onSuccess(httpResponse.params);
     } else {
       onFailure(httpResponse.err_code,httpResponse.err);
       
     }       
                 
     });
  }

   private doGet(querystring:String,onSuccess:any,onFailure:any){
    
    var url = this.backendURL + "" +querystring;
  
      return this.http.get(url).subscribe((httpResponse:any) => {
                console.log(httpResponse);
      if(httpResponse.success){
        onSuccess(httpResponse.data);
      } else {
        onFailure(httpResponse.err_code,httpResponse.err);
        
      }
      
                  
      });
}

  private doPost(querystring:any, data:any, onSuccess:any,onFailure:any){
    
    var url = this.backendURL + "" + querystring;



     return this.http.post(url,data).subscribe((httpResponse:any) => {
               console.log(httpResponse);
               console.log(data);
     if(httpResponse.success){
       onSuccess(httpResponse.data);
     } else {
       onFailure(httpResponse.err_code,httpResponse.err);
       
     }       
                 
     });
}

}
