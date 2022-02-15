import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CampoRichiesto } from 'src/app/exceptions/campo-richiesto';
import { Mese } from 'src/app/models/mese';
import { MeseService } from 'src/app/services/mese.service';
import { Location } from '@angular/common'
import { Dipendente } from 'src/app/models/dipendente';

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
  allMonths: boolean = true;
  enableEditIndex: any = null;
  singleMese : Mese;
  user : any = sessionStorage.getItem("utente")|| '{}';
  admin : Dipendente = new Dipendente();
 mesi : string;
 anni : string;
 giorni : string = "01";
  constructor(private servizio: MeseService, private router : Router, private location: Location) { 
    
  }


  ngOnInit(): void {
    this.elencoMesi()
  }

  elencoMesi(){
    this.servizio.elencoMesi(this.onSuccess.bind(this), this.onFailure.bind(this));
    this.showAll()
  }

  salva() {
    try {
      this.servizio.aggiungiMese(this.admin, this.onSuccess.bind(this), this.onFailure.bind(this));
      
      this.router.navigate(['/adminLoggedIn'])
    } catch (e) {
      if (e instanceof CampoRichiesto) {
        alert("il campo " + e.getField() + " è richiesto");
      }

      return false;
    }

    return true;
  }

  showAll(){
    this.allMonths = true;
  }

  switchEditMode(i: any) {
    this.isEditing = true;
    this.enableEditIndex = i;
  }

  selectYear(anni : any){

    this.daySelected(this.anni, "")
  }

  selectMonth(mesi : any){

    this.daySelected(this.anni, this.mesi)
  }

  daySelected(anni : string, mesi : string){
    var daySelected = this.anni + "-" + this.mesi + "-" + this.giorni;
    console.log(daySelected);
    if(this.anni!= undefined && this.mesi!=undefined){
      this.allMonths = false;
      this.servizio.elencoByMese(daySelected,this.onSuccessSingle.bind(this), this.onFailure.bind(this));
    }
  }

  save(mese : Mese) {
    console.log(mese);
    
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

  onSuccess(response : any) {
    this.listaMesi = response
  }

  onSuccessSingle(response : any) {
    if(response==null){
      this.listaMesi = null;
    }
    else{
      this.listaMesi=[]
    this.singleMese = response
    this.listaMesi.push(this.singleMese);}
  }

  onFailure(err: String) {
    alert("Operazione non andata a buon fine. Codice errore: "+err);
  }

 

  back(): void {
    this.location.back()
  }

}
