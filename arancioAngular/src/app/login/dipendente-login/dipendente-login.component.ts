import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Injectable, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { CampoRichiesto } from 'src/app/exceptions/campo-richiesto';
import { Dipendente } from 'src/app/models/dipendente';
import { dipendenteLoggato } from 'src/app/models/dipendenteLoggato';
import { DipendenteService } from 'src/app/services/dipendente.service';
import { LoginService } from 'src/app/services/login.service';
import { DipendenteLoggedinComponent } from '../dipendente-loggedin/dipendente-loggedin.component';

@Injectable({
  providedIn: 'root'
})
@Component({
  selector: 'app-dipendente-login',
  templateUrl: './dipendente-login.component.html',
  styleUrls: ['./dipendente-login.component.css']
})

export class DipendenteLoginComponent implements OnInit {
  @Output() timeEvent = new EventEmitter();

  constructor(public authService: LoginService, private router: Router, private apiservice: DipendenteService, private http: HttpClient) {

  }
  queryString: string = "/all";
  private backendURL: String = "http://localhost:8080/arancioRest/gestione_presenze/dipendente";
  private listaLavoratori: Array<Dipendente> = new Array<Dipendente>();
  model: Dipendente = new Dipendente();
  utente: Dipendente = new Dipendente();
  utenteLoggato: Dipendente = new Dipendente;


  ngOnInit(): void {
    this.utente = JSON.parse(sessionStorage.getItem("utente") || '{}');
    this.timeEvent.emit(this.utenteLoggato)
    if (this.utente.ruolo_fk == 'dipendente') {
      this.router.navigate(["/dipendenteLoggedIn"])
    }
    this.authService.logout();
  }

  login(model: any) {
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

    if (utenteLoggato == null) {
      return alert("Email o Password inseriti non corretti.")
    }
    if (utenteLoggato.email == this.model.email && utenteLoggato.password == this.model.password && utenteLoggato.ruolo_fk == 'admin') {
      this.authService.login()
      sessionStorage.setItem("utente", JSON.stringify(utenteLoggato))
      this.router.navigate(['/adminLoggedIn']);
    } else if (utenteLoggato.email == this.model.email && utenteLoggato.password == this.model.password && utenteLoggato.ruolo_fk == 'dipendente') {
      this.authService.login()
      sessionStorage.setItem("utente", JSON.stringify(utenteLoggato))
      this.router.navigate(['/dipendenteLoggedIn']);
    } else if (utenteLoggato.email == this.model.email && utenteLoggato.password == this.model.password && utenteLoggato.ruolo_fk == 'responsabile') {
      this.authService.login()
      sessionStorage.setItem("utente", JSON.stringify(utenteLoggato))
      this.router.navigate(['/responsabileLoggedIn']);
    } else {
      alert("Impossibile accedere. Username o password errati.")
    }
  }
  validateLogin() {

    if (this.model.email == null || this.model.email == '') {
      throw new CampoRichiesto('email');
    }
    if (this.model.password == null || this.model.password == '') {
      throw new CampoRichiesto('password');
    }

  }
  elencoUtenti() {
    this.apiservice.elenco2(this.queryString).subscribe(response => {
      this.listaLavoratori = response;
    })
  }



  public selectByEmail(email: string, onSuccess: any, onFailure: any) {

    var url = this.backendURL + "" + "/allByEmail?email=" + email;

    return this.http.get(url).subscribe((httpResponse: any) => {

      this.utenteLoggato = httpResponse

      if (httpResponse.successo == true) {
        onSuccess(httpResponse.data);
        this.verifica(this.utenteLoggato)
      } else {
        onFailure(httpResponse.codiceErrore, httpResponse.errore);

      }
    });
  }

  onLoginSuccess(result: Dipendente) {
    this.utenteLoggato = result;



  }
  onLoginFailure(err: string, err_code: string) {
    alert(err + " : " + err_code);
  }




}
