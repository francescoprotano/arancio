import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Dipendente } from '../models/dipendente';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  public isLoggedIn$: BehaviorSubject<boolean>;
  private backendURL :String = "http://localhost:8080/arancioRest/gestione_presenze/dipendente";
  constructor(private http : HttpClient) {
    const isLoggedIn = localStorage.getItem('loggedIn') === 'true';
    this.isLoggedIn$ = new BehaviorSubject(isLoggedIn);
  }

  login() {
    // logic
    localStorage.setItem('loggedIn', 'true');
    this.isLoggedIn$.next(true);
  }

  logout() {
    // logic
    localStorage.setItem('loggedIn', 'false');
    sessionStorage.clear();
    this.isLoggedIn$.next(false);
  }

  public loginAuth(model: Dipendente,onSuccess:any,onFailure:any) : void {
    this.doPost("/login",model,onSuccess,onFailure);
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
