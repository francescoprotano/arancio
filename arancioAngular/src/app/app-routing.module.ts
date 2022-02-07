import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddContrattoComponent } from './Contratto/add-contratto/add-contratto.component';
import { AllContrattiComponent } from './Contratto/all-contratti/all-contratti.component';
import { AddDipendenteComponent } from './Dipendente/add-dipendente/add-dipendenti/add-dipendente.component';
import { AllDipendentiComponent } from './Dipendente/add-dipendente/all-dipendenti/all-dipendenti.component';
import { AllDipendentiContractsComponent } from './Dipendente/all-dipendenti-contracts/all-dipendenti-contracts.component';
import { AdminLoggedinComponent } from './login/admin-loggedin/admin-loggedin.component';
import { DipendenteLoggedinComponent } from './login/dipendente-loggedin/dipendente-loggedin.component';
import { DipendenteLoginComponent } from './login/dipendente-login/dipendente-login.component';

const routes: Routes = [
  {path:'addDip',component:AddDipendenteComponent }
  ,{path: 'allDip', component:AllDipendentiComponent}
  ,{path: 'dipLogin', component:DipendenteLoginComponent}
  ,{path: 'dipendenteLoggedIn', component:DipendenteLoggedinComponent}
  ,{path: 'adminLoggedIn', component:AdminLoggedinComponent}
  ,{path: 'addContratto', component:AddContrattoComponent}
  ,{path: 'allContratti', component:AllContrattiComponent}
  ,{path: 'allDipContracts', component:AllDipendentiContractsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
