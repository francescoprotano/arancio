import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Dipendente } from 'src/app/models/dipendente';
import { DipendenteService } from 'src/app/services/dipendente.service';

@Component({
  selector: 'app-add-dipendente',
  templateUrl: './add-dipendente.component.html',
  styleUrls: ['./add-dipendente.component.css']
})
export class AddDipendenteComponent implements OnInit {

  model : Dipendente = new Dipendente();
  constructor(private servizio : DipendenteService,private router: Router) { 
  
  }

  ngOnInit() {
  }
  
  salva() {
		this.servizio.aggiungi(this.model,this.onSubmitSuccess.bind(this),this.onSubmitFailure.bind(this));
  }
  onSubmitSuccess(response:Dipendente) {
    alert("Dipendente inserito con successo!");
  }
  onSubmitFailure(err:String,err_code:String) {
		alert(err);
  }
  

}