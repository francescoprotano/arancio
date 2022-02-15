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
      this.authService.loginAuth(this.model, this.onLoginSuccess.bind(this), this.onLoginFailure.bind(this));
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
    this.authService.login()
    sessionStorage.setItem("utente", JSON.stringify(utenteLoggato))
    if (utenteLoggato.ruolo_fk == 'admin') {
      this.router.navigate(['/adminLoggedIn']);
    } else if (utenteLoggato.ruolo_fk == 'dipendente') {
      this.router.navigate(['/dipendenteLoggedIn']);
    } else if (utenteLoggato.ruolo_fk == 'responsabile') {
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
    this.apiservice.elenco(this.onLoginSuccess.bind(this),this.onLoginFailure.bind(this))

  }


  onLoginSuccess(result: Dipendente) {
    this.utenteLoggato = result;
    this.verifica(this.utenteLoggato);



  }
  onLoginFailure(err: string, err_code: string) {
    alert("Credenziali non valide: "+err);
  }




}
