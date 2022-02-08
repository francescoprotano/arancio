import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CampoRichiesto } from 'src/app/exceptions/campo-richiesto';
import { Mese } from 'src/app/models/mese';
import { MeseService } from 'src/app/services/mese.service';

@Component({
  selector: 'app-add-mese',
  templateUrl: './add-mese.component.html',
  styleUrls: ['./add-mese.component.css']
})
export class AddMeseComponent implements OnInit {
  model: Mese = new Mese();
  today = new Date()
  constructor(private servizio: MeseService, private router : Router) { }


  ngOnInit(): void {
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

  onSuccess() {
    alert("Mese inserito con successo!");
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
