import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { dipendenteLoggato } from 'src/app/models/dipendenteLoggato';
import { LoginService } from 'src/app/services/login.service';
import { DipendenteLoginComponent } from '../dipendente-login/dipendente-login.component';

@Component({
  selector: 'app-admin-loggedin',
  templateUrl: './admin-loggedin.component.html',
  styleUrls: ['./admin-loggedin.component.css']
})
export class AdminLoggedinComponent implements OnInit {
  model : dipendenteLoggato = new dipendenteLoggato();
  constructor(private router : Router, private login : DipendenteLoginComponent, private authService : LoginService) { }


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
  }

  aggiungiDipendente(){
    this.router.navigate(["/addDip"])
  }

 utenteLoggedIn(utenteLoggato : any){
   return this.model.email = utenteLoggato;

 }

aggiungiContratto(){
  this.router.navigate(["/addContratto"])
}

elencoContratti(){
  this.router.navigate(["/allContratti"])
}


}