import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CampoRichiesto } from 'src/app/exceptions/campo-richiesto';
import { Mese } from 'src/app/models/mese';
import { MeseService } from 'src/app/services/mese.service';

@Component({
  selector: 'app-add-mese',
  templateUrl: './add-all-mese.component.html',
  styleUrls: ['./add-all-mese.component.css']
})
export class AddMeseComponent implements OnInit {
  queryString : string = "/all";
  model: Mese = new Mese();
  today = new Date()
  listaMesi : Array<Mese> = new Array<Mese>(); 
  isEditing: boolean = false;
  enableEditIndex: any = null;
  constructor(private servizio: MeseService, private router : Router) { }


  ngOnInit(): void {
    this.elencoMesi()
  }

  elencoMesi(){
    this.servizio.elencoMesi(this.queryString).subscribe(response => {
      this.listaMesi = response;
   
    })
  }

  salva() {
    try {
      this.validateForward();
      this.servizio.aggiungiMese(this.model, this.onSuccess.bind(this), this.onFailure.bind(this));
      
      this.router.navigate(['/adminLoggedIn'])
    } catch (e) {
      if (e instanceof CampoRichiesto) {
        alert("il campo " + e.getField() + " è richiesto");
      }

      return false;
    }

    return true;
  }

  switchEditMode(i: any) {
    this.isEditing = true;
    this.enableEditIndex = i;
  }

  save(mese : Mese) {
    this.isEditing = false;
    this.enableEditIndex = null;
    this.servizio.aggiornaMese(mese,this.onSuccess,this.onFailure)
  }

  onRemove(codice:number) {
		this.servizio.eliminaMese(codice,this.onSuccess.bind(this),this.onFailure.bind(this));
    this.elencoMesi();
  }

  cancel() {
    this.isEditing = false;
    this.enableEditIndex = null;
  }

  onSuccess() {
    alert("Operazione eseguita con successo!");
  }
  onFailure(err: String) {
    alert("Operazione non andata a buon fine. Codice errore: "+err);
  }

  validateForward() {

    if (this.model.mese == null) {
      throw new CampoRichiesto('mese');
    }

  }

}
