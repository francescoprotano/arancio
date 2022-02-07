import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AllDipendentiComponent } from 'src/app/Dipendente/all-dipendenti/all-dipendenti.component';
import { dipendenteLoggato } from 'src/app/models/dipendenteLoggato';
import { DipendenteService } from 'src/app/services/dipendente.service';
import { LoginService } from 'src/app/services/login.service';
import { DipendenteLoginComponent } from '../dipendente-login/dipendente-login.component';



@Component({
  selector: 'app-dipendente-loggedin',
  templateUrl: './dipendente-loggedin.component.html',
  styleUrls: ['./dipendente-loggedin.component.css']
})
export class DipendenteLoggedinComponent implements OnInit {
  
  model : dipendenteLoggato = new dipendenteLoggato();
  getRuoloUtente!: string;
  constructor(private router : Router, private login : DipendenteLoginComponent, private authService : LoginService) {
    this.login.utenteLoggato;
    
  }

  elencoDipendenti(){
    this.router.navigate(["/allDip"])
  }

 
  
  ngOnInit(): void {
    if(!this.authService.isLoggedIn$){
      this.router.navigate(["/dipLogin"])
    }
    this.utenteLoggedIn(this.login.utenteLoggato)
  }

 utenteLoggedIn(utenteLoggato : any){
   console.log(utenteLoggato)
   return this.model.email = utenteLoggato;

 }

}
