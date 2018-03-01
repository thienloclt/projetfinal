import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { RouterModule, Routes} from '@angular/router';
import {DatePipe} from '@angular/common';
import { NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { TableModule} from 'primeng/table';
import {CalendarModule, OrderListModule, ProgressBarModule} from 'primeng/primeng';
import {SliderModule} from 'primeng/slider';
import {GrowlModule} from 'primeng/growl';


import { Globals} from './framework/globals';
import { IncidentService} from './service/incident.service';

import { AppComponent } from './app.component';
import { HeaderComponent } from './framework/header/header.component';
import { FooterComponent } from './framework/footer/footer.component';
import { MenuComponent } from './framework/menu/menu.component';
import { DashboardComponent } from './framework/dashboard/dashboard.component';
import { MatiereAddComponent } from './business/matiere/matiere-add/matiere-add.component';
import { MatiereListComponent } from './business/matiere/matiere-list/matiere-list.component';
import { SalleAddComponent } from './business/salle/salle-add/salle-add.component';
import { SalleListComponent } from './business/salle/salle-list/salle-list.component';
import { SalleDetailComponent } from './business/salle/salle-detail/salle-detail.component';

import { OrdinateurAddComponent } from './business/ordinateur/ordinateur-add/ordinateur-add.component';
import {EnseignementService} from './service/enseignement.service';
import {FormateurService} from './service/formateur.service';
import {GestionnaireService} from './service/gestionnaire.service';
import {MatiereService} from './service/matiere.service';
import {OrdinateurService} from './service/ordinateur.service';
import {ProjecteurService} from './service/projecteur.service';
import {SalleService} from './service/salle.service';
import { FormationAddComponent } from './business/formation/formation-add/formation-add.component';
import {FormationService} from './service/formation.service';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {StagiaireService} from './service/stagiaire.service';
import {TechnicienService} from './service/technicien.service';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: DashboardComponent},
  {path: 'matiere', component: MatiereListComponent},
  {path: 'matiere-add', component: MatiereAddComponent},
  {path: 'matiere-edit/:id', component: MatiereAddComponent},
  {path: 'salle', component: SalleListComponent},
  {path: 'salle-add', component: SalleAddComponent},
  {path: 'salle-edit/:id', component: SalleAddComponent},
  {path: 'salle/:id', component: SalleDetailComponent},
  {path: 'formation', component: FormationAddComponent},
  {path: 'formation-add', component: FormationAddComponent},
  {path: 'formation-edit/:id', component: FormationAddComponent},
  {path: 'formation/:id', component: FormationAddComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    MenuComponent,
    DashboardComponent,
    MatiereAddComponent,
    MatiereListComponent,
    SalleAddComponent,
    SalleListComponent,
    SalleDetailComponent,
    FormationAddComponent,
    OrdinateurAddComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    NgbModule.forRoot(),
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    TableModule,
    SliderModule,
    ProgressBarModule,
    GrowlModule,
    CalendarModule,
    BrowserAnimationsModule,
    OrderListModule
  ],

  providers: [Globals, IncidentService, DatePipe, EnseignementService, FormateurService,
    GestionnaireService, MatiereService, OrdinateurService, ProjecteurService,
    SalleService, StagiaireService, TechnicienService, FormationService],

  bootstrap: [AppComponent]
})

export class AppModule {
}
