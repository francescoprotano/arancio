import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Contratto } from 'src/app/models/contratto';
import { Location } from '@angular/common'
import { ContrattoService } from 'src/app/services/contratto.service';

@Component({
  selector: 'app-all-contratti',
  templateUrl: './all-contratti.component.html',
  styleUrls: ['./all-contratti.component.css']
})
export class AllContrattiComponent implements OnInit {
  listaContratti : Array<Contratto> = new Array<Contratto>(); 
  listaByTipologia : Array<Contratto> = new Array<Contratto>(); 
  queryString : string = "/allContratti";
  queryStringTipologia : string = "/allByTipologia?tipologia=";
  isEditing: boolean = false;
  enableEditIndex: any = null;
  contratto : Contratto = new Contratto()
  tipologia : string;
  showButton : Boolean = false;
  constructor(private service:ContrattoService,private router: Router, private location: Location) { }

  ngOnInit(): void {
    this.elencoContratti()
  }

  back(): void {
    this.location.back()
  }

  isDeterminato: boolean = false;
  selectInput(event : any) {
    let selected = event.target.value;
    if (selected == "indeterminato") {
      this.isDeterminato = false;
    } else {
      this.isDeterminato = true;
    }
  }

  switchEditMode(i: any) {
    this.isEditing = true;
    this.enableEditIndex = i;
  }

  onRemove(id_contratto:number) {
		this.service.eliminaContratto(id_contratto,this.onSuccess.bind(this),this.onFailure.bind(this));
    this.elencoContratti();
  }
  elencoContratti(){
    this.service.elencoContratti(this.onSuccess.bind(this),this.onFailure.bind(this))
    this.showButton = false;
  }


byTipologia(tipologia : string) {
  this.service.byTipologia(tipologia,this.onSuccess.bind(this),this.onFailure.bind(this))
  this.showButton = true;

}


  onSuccess(response:any) {
    this.listaContratti = []
    this.listaContratti = response

  }

  cancel() {
    this.isEditing = false;
    this.enableEditIndex = null;
  }

  onSuccessTipologia(response:any) {
    this.listaByTipologia = response
	
  }

  onFailure(err: String) {
    alert("Operazione non andata a buon fine. Codice errore: "+err);
  }
  
  save(c : Contratto) {
    this.isEditing = false;
    this.enableEditIndex = null;
    this.service.aggiornaContratto(c,this.onSuccess,this.onFailure)
  }

  
}
