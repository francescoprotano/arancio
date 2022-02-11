import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CampoRichiesto } from 'src/app/exceptions/campo-richiesto';
import { DataErrata } from 'src/app/exceptions/data-errata';
import { Dipendente } from 'src/app/models/dipendente';
import { dipendenteLoggato } from 'src/app/models/dipendenteLoggato';
import { Presenza } from 'src/app/models/presenza';
import { DipendenteService } from 'src/app/services/dipendente.service';
import { LoginService } from 'src/app/services/login.service';
import { PresenzaService } from 'src/app/services/presenza.service';
import { DipendenteLoginComponent } from '../dipendente-login/dipendente-login.component';




@Component({
  selector: 'app-dipendente-loggedin',
  templateUrl: './dipendente-loggedin.component.html',
  styleUrls: ['./dipendente-loggedin.component.css']
})
export class DipendenteLoggedinComponent implements OnInit {
  queryString: string = "/all";
  model : Dipendente = new Dipendente();
  getRuoloUtente!: string;
  isEditing: boolean = false;
  enableEditIndex: any = null;
  listaDipendenti : Array<Dipendente> = new Array<Dipendente>(); 
  listaPresenze : Array<Presenza> = new Array<Presenza>(); 
  nuovePresenze : Array<Presenza> = new Array<Presenza>(); 
  presenza: Presenza = new Presenza();

 user : any = sessionStorage.getItem("utente")|| '{}';
 utente : Dipendente= new Dipendente();


 

  constructor(private router : Router,  private authService : LoginService, private service:PresenzaService, private login : DipendenteLoginComponent) {
    

  }

  getStorage(){
    this.utente = JSON.parse(sessionStorage.getItem("utente")|| '{}');
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

cambiaPassword(){
  this.router.navigate(["/changePassword"])
}

insCheckPresenze(){
  this.router.navigate(["/insCheckPresenze"])
}




}
