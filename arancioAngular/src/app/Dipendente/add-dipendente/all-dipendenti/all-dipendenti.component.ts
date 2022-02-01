import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Dipendente } from 'src/app/models/dipendente';
import { DipendenteService } from 'src/app/services/dipendente.service';


@Component({
  selector: 'app-all-dipendenti',
  templateUrl: './all-dipendenti.component.html',
  styleUrls: ['./all-dipendenti.component.css']
})
export class AllDipendentiComponent implements OnInit {
  queryString : string = "/all";
  isEditing: boolean = false;
  enableEditIndex = null;
  listaDipendenti : Array<Dipendente> = new Array<Dipendente>(); 
  constructor(private service:DipendenteService,private router: Router) { }

  ngOnInit(): void {
    this.elenco2();
  }

  onRemove(codice:number) {
		this.service.elimina(codice,this.onRemoveSuccess.bind(this),this.onFailure.bind(this));
    this.elenco2();
  }


  redirectTo(uri: string) {
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
      this.router.navigate([uri]));
  }

  elenco2(){
    this.service.elenco2(this.queryString).subscribe(response => {
      this.listaDipendenti = response;
   
    })
  }


  onFailure(err:String,err_code:String) {
		
  }
  onRemoveSuccess(response:String) {

		this.onLoad();
  }
  onSetCompleteSuccess(response:String) {

		this.onLoad();
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
    this.service.aggiorna(d,this.onSuccess,this.onFailure)
  }

  cancel() {
    this.isEditing = false;
    this.enableEditIndex = null;
  }
  



onSuccess(err:String,err_code:String) {
		
}

}

