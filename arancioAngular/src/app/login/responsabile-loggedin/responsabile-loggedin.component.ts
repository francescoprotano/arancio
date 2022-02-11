import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Dipendente } from 'src/app/models/dipendente';
import { dipendenteLoggato } from 'src/app/models/dipendenteLoggato';
import { LoginService } from 'src/app/services/login.service';
import { DipendenteLoginComponent } from '../dipendente-login/dipendente-login.component';

@Component({
  selector: 'app-responsabile-loggedin',
  templateUrl: './responsabile-loggedin.component.html',
  styleUrls: ['./responsabile-loggedin.component.css']
})
export class ResponsabileLoggedinComponent implements OnInit {

  model : dipendenteLoggato = new dipendenteLoggato();
  user : any = sessionStorage.getItem("utente")|| '{}';
  utente : Dipendente= new Dipendente();
  constructor(private router : Router, private login : DipendenteLoginComponent, private authService : LoginService) { }

  getStorage(){
    this.utente = JSON.parse(sessionStorage.getItem("utente")|| '{}');
  }

  elencoDipendenti(){
    this.router.navigate(["/allDip"])
  }
  
  elencoDipendentiConContratto(){
    this.router.navigate(["/allDipContracts"])
  }

  ngOnInit(): void {
    if(!this.authService.isLoggedIn$){
      this.router.navigate(["/dipLogin"])
    }
    this.utenteLoggedIn(this.login.utenteLoggato)
    this.getStorage()
  }


 utenteLoggedIn(utenteLoggato : any){
   return this.model.email = utenteLoggato;

 }

revisionaPresenze(){
  this.router.navigate(["/insCheckPresenze"])
}

elencoContratti(){
  this.router.navigate(["/allContratti"])
}

cambiaPassword(){
  this.router.navigate(["/changePassword"])
}


}
