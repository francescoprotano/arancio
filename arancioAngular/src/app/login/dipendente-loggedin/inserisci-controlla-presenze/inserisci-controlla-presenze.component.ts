import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CampoRichiesto } from 'src/app/exceptions/campo-richiesto';
import { DataErrata } from 'src/app/exceptions/data-errata';
import { Dipendente } from 'src/app/models/dipendente';
import { Presenza } from 'src/app/models/presenza';
import { LoginService } from 'src/app/services/login.service';
import { PresenzaService } from 'src/app/services/presenza.service';
import { Location } from '@angular/common'

@Component({
  selector: 'app-inserisci-controlla-presenze',
  templateUrl: './inserisci-controlla-presenze.component.html',
  styleUrls: ['./inserisci-controlla-presenze.component.css']
})
export class InserisciControllaPresenzeComponent implements OnInit {

  queryString: string = "/all";
  model: Dipendente = new Dipendente();
  getRuoloUtente!: string;
  isEditing: boolean = false;
  enableEditIndex: any = null;
  listaDipendenti: Array<Dipendente> = new Array<Dipendente>();
  listaPresenze: Array<Presenza> = new Array<Presenza>();
  nuovePresenze: Array<Presenza> = new Array<Presenza>();
  presenza: Presenza = new Presenza();

  user: any = sessionStorage.getItem("utente") || '{}';
  utente: Dipendente = new Dipendente();




  constructor(private router: Router, private authService: LoginService, private service: PresenzaService, private location: Location) {


  }


  getStorage() {
    this.utente = JSON.parse(sessionStorage.getItem("utente") || '{}');
  }

  ngOnInit(): void {
    if (!this.authService.isLoggedIn$) {
      this.router.navigate(["/dipLogin"])
    }
    this.getStorage()
    this.elencoPresenze(this.utente.id_dipendente)
  }

  switchEditMode(i: any) {
    this.isEditing = true;
    this.enableEditIndex = i;
  }

  cancel() {
    this.isEditing = false;
    this.enableEditIndex = null;
  }

  save(p: Presenza) {
    this.isEditing = false;
    this.enableEditIndex = null;
    this.service.aggiornaPresenza(p, this.onSuccess, this.onFailure)
  }


  elencoPresenze(user_id: any) {
    user_id = this.utente.id_dipendente
    this.service.elencoPresenzeIndividual(user_id, this.onSuccess.bind(this), this.onFailure.bind(this))
  
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

  onSuccess(response:any) {
    this.listaPresenze = response;
  }
  onFailure(err: String) {
    alert("Operazione non andata a buon fine. Codice errore: " + err);
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

  back(): void {
    this.location.back()
  }

}
