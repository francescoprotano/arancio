import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddContrattoComponent } from './Contratto/add-contratto/add-contratto.component';
import { AllContrattiComponent } from './Contratto/all-contratti/all-contratti.component';
import { AddDipendenteComponent } from './Dipendente/add-dipendente/add-dipendenti/add-dipendente.component';
import { AllDipendentiComponent } from './Dipendente/all-dipendenti/all-dipendenti.component';
import { AllDipendentiContractsComponent } from './Dipendente/all-dipendenti-contracts/all-dipendenti-contracts.component';
import { AdminLoggedinComponent } from './login/admin-loggedin/admin-loggedin.component';
import { DipendenteLoggedinComponent } from './login/dipendente-loggedin/dipendente-loggedin.component';
import { DipendenteLoginComponent } from './login/dipendente-login/dipendente-login.component';
import { PasswordResetComponent } from './services/password-reset/password-reset.component';
import { AddMeseComponent } from './Mese/add-all-mese/add-all-mese.component';
import { PasswordChangeComponent } from './services/password-change/password-change.component';
import { InserisciControllaPresenzeComponent } from './login/dipendente-loggedin/inserisci-controlla-presenze/inserisci-controlla-presenze.component';

const routes: Routes = [
  {path:'addDip',component:AddDipendenteComponent }
  ,{path: 'allDip', component:AllDipendentiComponent}
  ,{path: 'dipLogin', component:DipendenteLoginComponent}
  ,{path: 'dipendenteLoggedIn', component:DipendenteLoggedinComponent}
  ,{path: 'adminLoggedIn', component:AdminLoggedinComponent}
  ,{path: 'addContratto', component:AddContrattoComponent}
  ,{path: 'allContratti', component:AllContrattiComponent}
  ,{path: 'allDipContracts', component:AllDipendentiContractsComponent}
  ,{path: 'resetPassword', component:PasswordResetComponent}
  ,{path: 'addMese', component:AddMeseComponent}
  ,{path: 'changePassword', component:PasswordChangeComponent}
  ,{path: 'insCheckPresenze', component:InserisciControllaPresenzeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
