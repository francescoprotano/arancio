import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddDipendenteComponent } from './Dipendente/add-dipendente/add-dipendenti/add-dipendente.component';
import { AllDipendentiComponent } from './Dipendente/add-dipendente/all-dipendenti/all-dipendenti.component';
import { DipendenteLoginComponent } from './login/dipendente-login/dipendente-login.component';
import { DipendenteLoggedinComponent } from './login/dipendente-loggedin/dipendente-loggedin.component';
import { AdminLoggedinComponent } from './login/admin-loggedin/admin-loggedin.component';
import { ResponsabileLoggedinComponent } from './login/responsabile-loggedin/responsabile-loggedin.component';
import { DatePipe } from '@angular/common';
import { AddContrattoComponent } from './Contratto/add-contratto/add-contratto.component';
import { AllContrattiComponent } from './Contratto/all-contratti/all-contratti.component';
import { AllDipendentiContractsComponent } from './Dipendente/all-dipendenti-contracts/all-dipendenti-contracts.component';




@NgModule({
  declarations: [
    AppComponent,
    AddDipendenteComponent,
    DipendenteLoginComponent,
    AllDipendentiComponent,
    DipendenteLoggedinComponent,
    AdminLoggedinComponent,
    ResponsabileLoggedinComponent,
    AddContrattoComponent,
    AllContrattiComponent,
    AllDipendentiContractsComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [DipendenteLoggedinComponent,AllDipendentiComponent, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
