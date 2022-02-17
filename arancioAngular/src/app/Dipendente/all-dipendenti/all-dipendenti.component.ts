import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Dipendente } from 'src/app/models/dipendente';
import { DipendenteService } from 'src/app/services/dipendente.service';
import { Location } from '@angular/common'
import { Contratto } from 'src/app/models/contratto';
import { ContrattoService } from 'src/app/services/contratto.service';


@Component({
  selector: 'app-all-dipendenti',
  templateUrl: './all-dipendenti.component.html',
  styleUrls: ['./all-dipendenti.component.css']
})
export class AllDipendentiComponent implements OnInit {
  queryString : string = "/all";
  isEditing: boolean = false;
  enableEditIndex: any = null;
  listaDipendenti : Array<Dipendente> = new Array<Dipendente>(); 
  listaContratti : Array<Contratto> = new Array<Contratto>();
  user: any = sessionStorage.getItem("utente") || '{}';
  utente: Dipendente = new Dipendente();
  constructor(private service:DipendenteService,private router: Router, private contrattoService : ContrattoService, private location: Location) { }

  ngOnInit(): void {
    this.getStorage();
    this.elenco2();
    this.elencoContratti();
  }

  getStorage() {
    this.utente = JSON.parse(sessionStorage.getItem("utente") || '{}');
  }


  onRemove(codice:number) {
		this.service.elimina(codice,this.onSuccess.bind(this),this.onFailure.bind(this));
    this.elenco2();
  }

  setStatus(stato:number){
    
  }
  elencoContratti(){
    this.contrattoService.elencoContratti(this.onSuccessContratti.bind(this),this.onFailure.bind(this))

  }

  redirectTo(uri: string) {
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
      this.router.navigate([uri]));
  }

  elenco2(){
    this.service.elenco(this.onSuccess.bind(this),this.onFailure.bind(this))
  }

  onSuccess(response:any) {
    this.listaDipendenti = response

  }

  onSuccessContratti(response : any){
    this.listaContratti = response
  }

  onUpdateSuccess(response:any) {
    alert("Utente modificato!")
    this.elenco2();

  }

  onFailure(err: String) {
    alert("Operazione non andata a buon fine. Codice errore: "+err);
  }
  
  

  onLoad() {
		this.elenco2();
  }
  switchEditMode(i: any) {
    this.isEditing = true;
    this.enableEditIndex = i;
  }

  save(d : Dipendente) {
    this.isEditing = false;
    this.enableEditIndex = null;
    this.service.aggiorna(d,this.onUpdateSuccess.bind(this),this.onFailure.bind(this))
  }

  cancel() {
    this.isEditing = false;
    this.enableEditIndex = null;
  }
  

  back(): void {
    this.location.back()
  }



}

