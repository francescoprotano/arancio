import { PasswordValidators } from './password.validators';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { DipendenteService } from '../dipendente.service';
import { Dipendente } from 'src/app/models/dipendente';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { Location } from '@angular/common'

@Component({
  selector: 'app-password-change',
  templateUrl: './password-change.component.html',
  styleUrls: ['./password-change.component.css']
})
export class PasswordChangeComponent implements OnInit {
  form: FormGroup;
  model: Dipendente = new Dipendente();

  constructor(fb: FormBuilder, private apiservice: DipendenteService, private log : LoginService, private router : Router, private location: Location) {
    this.form = fb.group({
      newPassword: ['', Validators.required],
      confirmPassword: ['', Validators.required]
    }, {
      validator: PasswordValidators.passwordsShouldMatch
    });
  }
  ngOnInit(): void {
    this.model = JSON.parse(sessionStorage.getItem("utente") || '{}');
  }

  get newPassword() { return this.form.get('newPassword'); }
  get confirmPassword() { return this.form.get('confirmPassword'); }


  verifica(pass: any) {
    console.log(this.newPassword.value)
    this.model.password = this.newPassword.value
      this.apiservice.aggiornaPassword(this.model, this.onSuccess, this.onFailure)
      this.log.logout()
      this.router.navigate(["/dipLogin"]);
  }

  back(): void {
    this.location.back()
  }

  onSuccess() {
    alert("Password cambiata!")
    
  }

  onFailure(err: String) {
    alert("Operazione non andata a buon fine. Codice errore: " + err);
  }
}