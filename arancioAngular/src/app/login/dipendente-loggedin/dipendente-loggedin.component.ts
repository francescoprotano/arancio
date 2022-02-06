import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AllDipendentiComponent } from 'src/app/Dipendente/add-dipendente/all-dipendenti/all-dipendenti.component';
import { dipendenteLoggato } from 'src/app/models/dipendenteLoggato';
import { DipendenteService } from 'src/app/services/dipendente.service';
import { DipendenteLoginComponent } from '../dipendente-login/dipendente-login.component';



@Component({
  selector: 'app-dipendente-loggedin',
  templateUrl: './dipendente-loggedin.component.html',
  styleUrls: ['./dipendente-loggedin.component.css']
})
export class DipendenteLoggedinComponent implements OnInit {
  
  model : dipendenteLoggato = new dipendenteLoggato();
  getRuoloUtente!: string;
  constructor(private router : Router, private login : DipendenteLoginComponent) {
    this.login.utenteLoggato;
    
  }

  elencoDipendenti(){
    this.router.navigate(["/allDip"])
  }

 
  
  ngOnInit(): void {
    this.utenteLoggedIn(this.login.utenteLoggato)
  }

 utenteLoggedIn(utenteLoggato : any){
   console.log(utenteLoggato)
   return this.model.email = utenteLoggato;

 }

}
