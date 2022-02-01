import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddDipendenteComponent } from './Dipendente/add-dipendente/add-dipendente.component';
import { AllDipendentiComponent } from './Dipendente/add-dipendente/all-dipendenti/all-dipendenti.component';


const routes: Routes = [
  {path:'addDip',component:AddDipendenteComponent }
  ,{path: 'allDip', component:AllDipendentiComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
