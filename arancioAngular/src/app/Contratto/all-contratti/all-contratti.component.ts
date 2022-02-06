import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Contratto } from 'src/app/models/contratto';
import { DipendenteService } from 'src/app/services/dipendente.service';

@Component({
  selector: 'app-all-contratti',
  templateUrl: './all-contratti.component.html',
  styleUrls: ['./all-contratti.component.css']
})
export class AllContrattiComponent implements OnInit {
  listaContratti : Array<Contratto> = new Array<Contratto>(); 
  queryString : string = "/allContratti";
  isEditing: boolean = false;
  enableEditIndex = null;
  constructor(private service:DipendenteService,private router: Router) { }

  ngOnInit(): void {
    this.elencoContratti()
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
    this.service.elencoContratti(this.queryString).subscribe(response => {
      this.listaContratti = response;
   
    })
  }
  onSuccess(response:String) {

	
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
