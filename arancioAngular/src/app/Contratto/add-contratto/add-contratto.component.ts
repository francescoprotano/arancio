import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CampoRichiesto } from 'src/app/exceptions/campo-richiesto';
import { DataErrata } from 'src/app/exceptions/data-errata';
import { DataIncompatibile } from 'src/app/exceptions/data-incompatibile';
import { Contratto } from 'src/app/models/contratto';
import { DipendenteService } from 'src/app/services/dipendente.service';

@Component({
  selector: 'app-add-contratto',
  templateUrl: './add-contratto.component.html',
  styleUrls: ['./add-contratto.component.css']
})
export class AddContrattoComponent implements OnInit {
  model: Contratto = new Contratto();
  today = new Date()
  constructor(private servizio: DipendenteService, private router : Router) { }


  isDeterminato: boolean = false;
  selectInput(event : any) {
    let selected = event.target.value;
    if (selected == "indeterminato") {
      this.isDeterminato = false;
    } else {
      this.isDeterminato = true;
    }
  }

  ngOnInit(): void {
  }

  salva() {
    try {
      this.validateForward();
      this.servizio.aggiungiContratto(this.model, this.onSuccess.bind(this), this.onFailure.bind(this));
      
      this.router.navigate(['/adminLoggedIn'])
    } catch (e) {
      if (e instanceof CampoRichiesto) {
        alert("il campo " + e.getField() + " è richiesto");
      }
      if (e instanceof DataErrata) {
        alert("il campo " + e.getField() + " inserito si riferisce ad una data futura!");
      }
      if (e instanceof DataIncompatibile) {
        alert("il campo " + e.getField() + " inserito non e' compatibile in quanto la data di scadenza non puo' avvenire prima della data di assunzione!");
      }

      return false;
    }

    return true;
  }

  onSuccess() {
    alert("Contratto inserito con successo!");
  }
  onFailure(err: String) {
    alert("Operazione non andata a buon fine. Codice errore: "+err);
  }

  validateForward() {

    if (this.model.data_assunzione == null) {
      throw new CampoRichiesto('data_assunzione');
    }
    if (this.model.data_scadenza == null && this.model.tipologia != 'indeterminato') {
      throw new CampoRichiesto('data_scadenza');
    }
    if (this.model.tipologia == null || this.model.tipologia == '') {
      throw new CampoRichiesto('tipologia');
    }
    if (this.model.id_dipendente_fk == null || this.model.id_dipendente_fk == 0) {
      throw new CampoRichiesto('id_dipendente_fk');
    }
    
    this.verificaData(this.model.data_assunzione, this.model.data_scadenza)

  }

  verificaData(data_assunzione: Date, data_scadenza: Date): boolean {
    var data_assunzione = new Date(data_assunzione)
    var data_scadenza = new Date(data_scadenza)

    if (data_scadenza < data_assunzione){
      throw new DataIncompatibile('data_scadenza')
    }

    return false
  }

}
