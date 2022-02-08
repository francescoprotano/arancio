import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
  enableEditIndex = null;
  listaDipendenti : Array<Dipendente> = new Array<Dipendente>(); 
  listaPresenze : Array<Presenza> = new Array<Presenza>(); 
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
 onSuccess(err:String,err_code:String) {
		
}

onFailure(err: String) {
  alert("Operazione non andata a buon fine. Codice errore: "+err);
}

}
