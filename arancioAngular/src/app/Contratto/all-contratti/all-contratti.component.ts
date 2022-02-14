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

  }

  byTipologiaX(tipologia : string) {
    console.log(tipologia)
    this.service.byTipologiaX(tipologia, this.responseTipologia.bind(this))  
}

byTipologia(tipologia : string) {
  this.service.byTipologia(this.queryStringTipologia+tipologia).subscribe(response => {
    console.log(response)
    if(response == null){
      alert("C'e' stato un errore interno. Riprova piu' tardi. CODICE ERRORE: response = null ")
    }else if(response.length==0){
      alert("Nessun dipendente con questo tipo di contratto.")
    }
    this.listaByTipologia = response
 
  })
}

responseTipologia(risposta:any){
  if(risposta.successo){
    alert('rispsota della lista' + risposta.data)
    this.listaByTipologia=risposta.data
  } else {
    alert(risposta.errore)
  }
}

  onSuccess(response:any) {
    this.listaContratti = response.data
	
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
