import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Contratto } from 'src/app/models/contratto';
import { Dipendente } from 'src/app/models/dipendente';
import { DipendenteService } from 'src/app/services/dipendente.service';

@Component({
  selector: 'app-all-dipendenti-contracts',
  templateUrl: './all-dipendenti-contracts.component.html',
  styleUrls: ['./all-dipendenti-contracts.component.css']
})
export class AllDipendentiContractsComponent implements OnInit {
  queryString : string = "/allJoinDipendentiEContratti";
  isEditing: boolean = false;
  enableEditIndex: any = null;
  listaDipendenti : Array<Dipendente> = new Array<Dipendente>(); 
  listaContratti : Array<Contratto> = new Array<Contratto>(); 
  constructor(private service:DipendenteService,private router: Router) { }

  ngOnInit(): void {
    this.elencoDipendenti();
  }

  onRemove(codice:number) {
		this.service.elimina(codice,this.onSuccess.bind(this),this.onFailure.bind(this));
    this.elencoDipendenti();
  }


  redirectTo(uri: string) {
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
      this.router.navigate([uri]));
  }

  elencoDipendenti(){
    this.service.elencoByContratto(this.onSuccess.bind(this),this.onFailure.bind(this))

  }

  onSuccess(response:any) {
    this.listaDipendenti = response

  }

  onFailure(err: String) {
    alert("Operazione non andata a buon fine. Codice errore: "+err);
  }
  
  

  onLoad() {
		this.elencoDipendenti();
  }
  switchEditMode(i: any) {
    this.isEditing = true;
    this.enableEditIndex = i;
  }

  save(d : Dipendente) {
    this.isEditing = false;
    this.enableEditIndex = null;
    this.service.aggiorna(d,this.onSuccess,this.onFailure)
  }

  cancel() {
    this.isEditing = false;
    this.enableEditIndex = null;
  }
  
}
