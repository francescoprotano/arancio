import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CampoRichiesto } from 'src/app/exceptions/campo-richiesto';
import { DataErrata } from 'src/app/exceptions/data-errata';
import { Dipendente } from 'src/app/models/dipendente';
import { Presenza } from 'src/app/models/presenza';
import { LoginService } from 'src/app/services/login.service';
import { PresenzaService } from 'src/app/services/presenza.service';
import { Location } from '@angular/common'
import { DipendenteMese } from 'src/app/models/dipendenteMese';
import { DipendenteMeseService } from 'src/app/services/dipendente-mese.service';
import { Mese } from 'src/app/models/mese';
import { MeseService } from 'src/app/services/mese.service';
import { AnonymousSubject } from 'rxjs/internal/Subject';

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
  presenza: Presenza = new Presenza();
  dipendenteMese: DipendenteMese = new DipendenteMese();
  mesi: number;
  anni: number;
  giorni: string = "01";
  user: any = sessionStorage.getItem("utente") || '{}';
  utente: Dipendente = new Dipendente();
  allMonths: boolean = true;
  singlePresenza: Presenza;
  id_presenza : number;
  dataSelected : Date;



  constructor(private router: Router, private authService: LoginService, private service: PresenzaService,
    private dipMesService: DipendenteMeseService, private meseService : MeseService, private location: Location) {

    this.utente = JSON.parse(sessionStorage.getItem("utente") || '{}');
    this.dipendenteMese.id_dipendente_fk = this.utente.id_dipendente;


  }


  getStorage() {
    this.utente = JSON.parse(sessionStorage.getItem("utente") || '{}');
  }

  ngOnInit(): void {
    if (!this.authService.isLoggedIn$) {
      this.router.navigate(["/dipLogin"])
    }
    this.getStorage()
    if (this.utente.ruolo_fk == 'dipendente') {
      this.elencoPresenze(this.utente.id_dipendente)
    }
    if (this.utente.ruolo_fk == 'responsabile') {
      this.elencoTuttePresenze();
    }
    this.dipMesService.findStatus(this.dipendenteMese,this.onSuccess.bind(this), this.onFailure.bind(this));
  }

  switchEditMode(i: any) {
    this.isEditing = true;
    this.enableEditIndex = i;
  }

  cancel() {
    this.isEditing = false;
    this.enableEditIndex = null;
  }

  save(singlePresenza : Presenza) {
    this.isEditing = false;
    this.enableEditIndex = null;
    this.singlePresenza =singlePresenza 
    console.log(this.singlePresenza)
    this.service.aggiornaPresenza(singlePresenza, this.onSuccessModifica.bind(this), this.onFailure.bind(this))
  }

  inviaMese(p : Presenza){
    this.dipendenteMese.id_dipendente_fk = p.id_dipendente_fk
    this.dipendenteMese.id_mese_fk = p.id_mese_fk
    this.dipMesService.sendMonth(this.dipendenteMese, this.onSuccess, this.onFailure)
  }

  selectStatus() {
    this.dipMesService.findStatus(this.dipendenteMese, this.onSuccess.bind(this), this.onFailure.bind(this))
  }

  elencoPresenze(user_id: any) {
    user_id = this.utente.id_dipendente
    this.selectStatus();
    this.showAll()
  }


  elencoTuttePresenze() {
    this.service.elencoPresenze(this.onSuccess.bind(this), this.onFailure.bind(this))
    this.showAll()

  }

  selectYear(anni: any) {

    this.daySelected(this.anni , null)

  }

  selectMonth(mesi: any) {

    this.daySelected(this.anni, this.mesi)
  }

  daySelected(anni: number, mesi: number) {
   // this.dataSelected = this.anni + "-" + this.mesi + "-" + this.giorni;

   this.dataSelected=new Date(anni,mesi,1)
    console.log(this.daySelected);
    if (this.anni != undefined && this.mesi != null) {
      this.listaPresenze = []
      this.allMonths = false;
      this.service.elencoByMese(this.dataSelected, this.onSuccess.bind(this), this.onFailure.bind(this));
    }
  }
  showAll() {
    this.allMonths = true;
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

  onSuccess(response: any) {
    if (response == null) {
      this.listaPresenze = null;
    }
    else {
      this.listaPresenze = []
      this.listaPresenze = response
      console.log(this.listaPresenze)

    }
  }

  onSuccessModifica(response:any){
    alert("Modifica avvenuta con successo.")
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
