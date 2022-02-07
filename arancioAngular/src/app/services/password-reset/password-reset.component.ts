import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CampoRichiesto } from 'src/app/exceptions/campo-richiesto';
import { Dipendente } from 'src/app/models/dipendente';
import { dipendenteLoggato } from 'src/app/models/dipendenteLoggato';
import { DipendenteService } from '../dipendente.service';

@Component({
  selector: 'app-password-reset',
  templateUrl: './password-reset.component.html',
  styleUrls: ['./password-reset.component.css']
})
export class PasswordResetComponent implements OnInit {
model : Dipendente = new Dipendente();
queryString: string = "/all";
utenteLoggato: dipendenteLoggato = new dipendenteLoggato();
newDipendentePassword : Dipendente = new Dipendente();
  private backendURL: String = "http://localhost:8080/arancioRest/gestione_presenze/dipendente";

  constructor(private router: Router, private apiservice: DipendenteService, private http: HttpClient) { }

  ngOnInit(): void {
  }

  check(model: any) {
    this.model = model;
    try {
    this.validateLogin();
    this.selectByEmail(model.email, this.onLoginSuccess.bind(this), this.onLoginFailure.bind(this));
  } catch (e) {
    if (e instanceof CampoRichiesto) {
      alert("il campo " + e.getField() + " è richiesto");
    }

    return false;
  }
  return true;
  }

  verifica(utenteLoggato: any) {
  
    if(utenteLoggato == null){
    return  alert("Email inserita non trovata nei nostri records.")
    }
    if (utenteLoggato.email == this.model.email) {
      var randomstring = Math.random().toString(36).slice(-8);
      this.newDipendentePassword.password = randomstring;
      alert("La tua nuova password e': "+randomstring)
      this.apiservice.aggiornaPassword(this.newDipendentePassword,this.onSuccess,this.onFailure)
      this.router.navigate(['/dipLogin']);
    } 
  }




  public selectByEmail(email: string, onSuccess: any, onFailure: any) {

    var url = this.backendURL + "" + "/allByEmail?email=" + email;

    return this.http.get(url).subscribe((httpResponse: any) => {

      this.utenteLoggato = httpResponse
      if (httpResponse.successo == true) {
        onSuccess(httpResponse.data);
        this.verifica(this.utenteLoggato)
        console.log(this.utenteLoggato)
      } else {
        onFailure(httpResponse.codiceErrore, httpResponse.errore);

      }
    });
  }
  validateLogin() {

    if (this.model.email == null || this.model.email == '') {
      throw new CampoRichiesto('email');
    }

  }
  onSuccess(err:String,err_code:String) {
		
  }

  onFailure(err: String) {
    alert("Operazione non andata a buon fine. Codice errore: "+err);
  }

  onLoginSuccess(result: dipendenteLoggato) {
    this.utenteLoggato = result;



  }
  onLoginFailure(err: string, err_code: string) {
    alert(err + " : " + err_code);
  }



}
