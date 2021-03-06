import { Component, OnInit } from '@angular/core';
import { Data, Router } from '@angular/router';
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
import { DipendenteService } from 'src/app/services/dipendente.service';

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
  id_presenza: number;
  dataSelected: Date;
  meseInviato: Boolean = false;
  approvaMese : Boolean = false;
  rendiModificabile : Boolean = false;
  dipendenteSelezionato : Dipendente;
  idSelezionato : number;
  nomeSelezionato : string ;
  cognomeSelezionato : string;
  statoMese : number;
  listaDipMesi : Array<DipendenteMese> = new Array<DipendenteMese>()
  id_dip : number;
  statusClosed : boolean;
  dipendenteMesePerResp : DipendenteMese = new DipendenteMese()


  constructor(private router: Router, private authService: LoginService, private service: PresenzaService,
    private dipMesService: DipendenteMeseService, private meseService: MeseService, private location: Location, private dipendenteService : DipendenteService) {

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
      this.selectAllDipendenti();
      
    }
   
  }

  dipDipMesiMesi(dipendenteMesePerResp : DipendenteMese){
    this.dipMesService.selectAll(dipendenteMesePerResp,this.onSuccessdipdipMesiMesi.bind(this),this.onFailure.bind(this))
  }

  switchEditMode(i: any) {
    this.isEditing = true;
    this.enableEditIndex = i;
  }

  cancel() {
    this.isEditing = false;
    this.enableEditIndex = null;
  }

  selectAllDipendenti(){
    this.dipendenteService.elenco(this.onSuccessDipendenti.bind(this),this.onFailure.bind(this))
  }

  save(singlePresenza: Presenza) {
    this.isEditing = false;
    this.enableEditIndex = null;
    this.singlePresenza = singlePresenza
    console.log(this.singlePresenza)
    this.service.aggiornaPresenza(singlePresenza, this.onSuccessModifica.bind(this), this.onFailure.bind(this))
  }

  inviaMese(p: Presenza) {
    this.dipendenteMese.id_dipendente_fk = p.id_dipendente_fk
    this.dipendenteMese.id_mese_fk = p.id_mese_fk
    this.dipMesService.sendMonth(this.dipendenteMese, this.onSuccessSendMese.bind(this), this.onFailure.bind(this))
  }

  approvaSingoloMese(p : Presenza) {
    this.dipendenteMese.stato = 2;
    this.dipendenteMese.id_dipendente_fk = p.id_dipendente_fk
    this.dipendenteMese.id_mese_fk = p.id_mese_fk
    this.dipMesService.sendMonth(this.dipendenteMese, this.onSuccessSendMese.bind(this), this.onFailure.bind(this))
  }

  selectStatus() {
    this.dipMesService.selectAll(this.dipendenteMese, this.onSuccess.bind(this), this.onFailure.bind(this))
  }

  elencoPresenze(user_id: any) {
    user_id = this.utente.id_dipendente
    this.selectStatus();
    this.showAll()
  }


  elencoTuttePresenze() {
   this.service.elencoAllPresenze(this.utente, this.onSuccess.bind(this), this.onFailure.bind(this))
    this.showAll()

  }

  selectYear(anni: any) {

    this.daySelected(this.anni, null)

  }

  selectMonth(mesi: any) {

    this.daySelected(this.anni, this.mesi)
  }

  selectId(id_dipendente : number){
    this.selectByDipendenteAndMese(this.anni,this.mesi,id_dipendente)
  }

  selectByDipendenteAndMese(anni: number, mesi: number, id_dipendente : number){
    id_dipendente = this.idSelezionato;
    console.log("id dip: "+id_dipendente)
    this.dataSelected = new Date(anni, mesi, 1)
    if (this.anni != undefined && this.mesi != undefined && id_dipendente != undefined) {
      this.dipendenteMesePerResp.id_dipendente_fk = id_dipendente
      this.dipDipMesiMesi(this.dipendenteMesePerResp)
      this.listaDipMesi.forEach(element => {
        if(element.id_dipendente_fk == this.idSelezionato ){
          this.id_dip = element.id_dipendente_fk
        }
      });
      console.log("id dippppppp "+this.id_dip)
        console.log("statussss "+this.statusClosed)

      this.approvaMese = true
      this.listaPresenze = []
      this.service.presenzeDipMese(this.dataSelected, id_dipendente, this.onSuccessFiltraMese.bind(this), this.onFailure.bind(this));
     

    }
  }

  daySelected(anni: number, mesi: number) {
    this.dataSelected = new Date(anni, mesi, 1)
    if (this.anni != undefined && this.mesi != null) {
      this.listaPresenze = []
      this.allMonths = false;
      this.service.elencoByMese(this.dataSelected, this.onSuccessFiltraMese.bind(this), this.onFailure.bind(this));
    }
  }

  daySelectedResponsabile(anni: number, mesi: number) {
    this.dataSelected = new Date(anni, mesi, 1)
    if (this.anni != undefined && this.mesi != null) {
      this.listaPresenze = []
      this.allMonths = false;
      this.dipendenteService.elenco(this.onSuccessFiltraMese.bind(this), this.onFailure.bind(this))
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
      this.router.navigate(['/dipendenteLoggedIn'])
    } catch (e) {
      if (e instanceof CampoRichiesto) {
        alert("il campo " + e.getField() + " ?? richiesto");
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
      if(this.utente.ruolo_fk=='responsabile' && this.dipendenteSelezionato!= null){
        this.approvaMese = true;
        this.rendiModificabile = true;
      } if(this.utente.ruolo_fk!='responsabile'){
      this.listaPresenze.forEach(element => {
        if (element.dipendenteMese.stato == 0) {
          this.meseInviato == false
        } else {
          this.meseInviato == true
        }
      });
    }
    }
    
  }

  onSuccessDipendenti(response : any){
    this.listaDipendenti = response
  }

  onSuccessdipdipMesiMesi(response : any){
    console.log(response)
    this.listaDipMesi = response
    this.listaDipMesi.forEach(element => {
      if(this.idSelezionato == element.dipendenteMese.id_dipendente_fk){
      console.log(element.dipendenteMese.stato)
    }});
    
  }

  onSuccessFiltraMese(response: any) {
    if (response == null) {
      this.listaPresenze = null;
    }
    else {
      this.listaPresenze = []
      this.listaPresenze = response.presenze
      this.nomeSelezionato = response.nome
      this.cognomeSelezionato = response.cognome

    }
  }

  onSuccessSendMese(response: any) {
    this.statoMese = response.stato
    this.meseInviato = true;
  }

  onSuccessModifica(response: any) {
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
