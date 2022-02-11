import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CampoRichiesto } from 'src/app/exceptions/campo-richiesto';
import { Dipendente } from 'src/app/models/dipendente';
import { DipendenteService } from 'src/app/services/dipendente.service';
import { DatePipe } from '@angular/common'
import { DataErrata } from 'src/app/exceptions/data-errata';
import { Location } from '@angular/common'

@Component({
  selector: 'app-add-dipendente',
  templateUrl: './add-dipendente.component.html',
  styleUrls: ['./add-dipendente.component.css']
})
export class AddDipendenteComponent implements OnInit {

  model: Dipendente = new Dipendente();

  myDate = new Date()



  constructor(private servizio: DipendenteService, private router: Router, public datePipe: DatePipe, private location: Location) {

  }



  ngOnInit() {

  }

  back(): void {
    this.location.back()
  }

  salva() {
    try {
      this.validateForward();
      this.servizio.aggiungi(this.model, this.onSuccess.bind(this), this.onFailure.bind(this));
      
      this.router.navigate(['/adminLoggedIn'])
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
    alert("Dipendente inserito con successo!");
  }
  onFailure(err: String) {
    alert("Operazione non andata a buon fine. Codice errore: "+err);
  }

  validateForward() {
    if (this.model.nome == null || this.model.nome == '') {
      throw new CampoRichiesto('nome');
    }
    if (this.model.cognome == null || this.model.cognome == '') {
      throw new CampoRichiesto('cognome');
    }
    if (this.model.email == null || this.model.email == '') {
      throw new CampoRichiesto('email');
    }
    if (this.model.password == null || this.model.password == '') {
      throw new CampoRichiesto('password');
    }
    if (this.model.ruolo_fk == null || this.model.ruolo_fk == '') {
      throw new CampoRichiesto('ruolo');
    }
    if (this.model.data_nascita == null) {
      throw new CampoRichiesto('data_nascita');
    }
    this.verificaData(this.model.data_nascita)

  }

  verificaData(data_nascita: Date): boolean {
    var data = new Date(data_nascita)
    if (data > this.myDate) {

      throw new DataErrata('data_nascita');
    }

    return false
  }


}