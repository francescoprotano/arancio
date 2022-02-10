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


 

  constructor(private router : Router,  private authService : LoginService, private service:PresenzaService) {
    

  }

  
 getStorage(){
   this.utente = JSON.parse(sessionStorage.getItem("utente")|| '{}');
 }
  
  ngOnInit(): void {
    if(!this.authService.isLoggedIn$){
      this.router.navigate(["/dipLogin"])
    }
    this.elencoPresenze()
    this.getStorage()
  }

  switchEditMode(i: any) {
    this.isEditing = true;
    this.enableEditIndex = i;
  }

  cancel(){
    this.isEditing = false;
    this.enableEditIndex = null;
  }

  save(p : Presenza) {
    this.isEditing = false;
    this.enableEditIndex = null;
    this.service.aggiornaPresenza(p,this.onSuccess,this.onFailure)
  }


  elencoPresenze(){
    this.service.elencoPresenze(this.queryString).subscribe(response => {
      this.listaPresenze = response;
   
    })
  }
 


salva() {
  try {
    this.presenza.id_dipendente_fk = this.utente.id_dipendente;
    this.validateForward();
    this.service.aggiungiPresenza(this.presenza, this.onSuccess.bind(this), this.onFailure.bind(this));
    console.log(this.presenza)
    this.router.navigate(['/dipendenteLoggedIn'])
  } catch (e) {
    if (e instanceof CampoRichiesto) {
      alert("il campo " + e.getField() + " è richiesto");
    }
    if (e instanceof DataErrata) {
      alert("il campo " + e.getField() + " inserito si riferisce ad una data futura!");
    }

    return false;
  }

  return true;
}

onSuccess() {
  alert("Presenza inserita con successo!");
}
onFailure(err: String) {
  alert("Operazione non andata a buon fine. Codice errore: "+err);
}

validateForward() {
  if (this.presenza.data == null) {
    throw new CampoRichiesto('data');
  }
  if (this.presenza.ore_lavorate == null) {
    throw new CampoRichiesto('ore lavorate');
  }
  if (this.presenza.ore_assenza == null) {
    throw new CampoRichiesto('ore assenza');
  }
  if (this.presenza.motivazione_assenza_fk == null || this.presenza.motivazione_assenza_fk == '') {
    throw new CampoRichiesto('motivazione assenza');
  }


}




}
