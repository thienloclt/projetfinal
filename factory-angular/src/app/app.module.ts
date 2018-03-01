import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { RouterModule, Routes} from '@angular/router';
import {DatePipe} from '@angular/common';
import { NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { TableModule} from 'primeng/table';
import { ProgressBarModule} from 'primeng/primeng';
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
import {StagiaireService} from './service/stagiaire.service';
import {TechnicienService} from './service/technicien.service';
import { OrdinateurListComponent } from './business/ordinateur/ordinateur-list/ordinateur-list.component';
import { OrdinateurDetailComponent } from './business/ordinateur/ordinateur-detail/ordinateur-detail.component';
import { ProjecteurAddComponent } from './business/projecteur/projecteur-add/projecteur-add.component';
import { ProjecteurListComponent } from './business/projecteur/projecteur-list/projecteur-list.component';
import { ProjecteurDetailComponent } from './business/projecteur/projecteur-detail/projecteur-detail.component';
import { TechnicienDetailComponent } from './business/technicien/technicien-detail/technicien-detail.component';
import { TechnicienListComponent } from './business/technicien/technicien-list/technicien-list.component';
import { TechnicienAddComponent } from './business/technicien/technicien-add/technicien-add.component';
import { StagiaireAddComponent } from './business/stagiaire/stagiaire-add/stagiaire-add.component';
import { StagiaireListComponent } from './business/stagiaire/stagiaire-list/stagiaire-list.component';
import { StagiaireDetailComponent } from './business/stagiaire/stagiaire-detail/stagiaire-detail.component';
import { GestoniaireDetailComponent } from './business/gestionnaire/gestoniaire-detail/gestoniaire-detail.component';
import { GestoniaireAddComponent } from './business/gestionnaire/gestoniaire-add/gestoniaire-add.component';
import { GestoniaireListComponent } from './business/gestionnaire/gestoniaire-list/gestoniaire-list.component';
import { FormateurListComponent } from './business/formateur/formateur-list/formateur-list.component';
import { FormateurAddComponent } from './business/formateur/formateur-add/formateur-add.component';
import { FormateurDetailComponent } from './business/formateur/formateur-detail/formateur-detail.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: DashboardComponent},
  {path: 'matiere', component: MatiereListComponent},
  {path: 'matiere-add', component: MatiereAddComponent},
  {path: 'matiere-edit/:id', component: MatiereAddComponent},
  {path: 'salle', component: SalleListComponent},
  {path: 'salle-add', component: SalleAddComponent},
  {path: 'salle-edit/:id', component: SalleAddComponent},
  {path: 'salle/:id', component: SalleDetailComponent}
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
    OrdinateurAddComponent,
    OrdinateurListComponent,
    OrdinateurDetailComponent,
    ProjecteurAddComponent,
    ProjecteurListComponent,
    ProjecteurDetailComponent,
    TechnicienDetailComponent,
    TechnicienListComponent,
    TechnicienAddComponent,
    StagiaireAddComponent,
    StagiaireListComponent,
    StagiaireDetailComponent,
    GestoniaireDetailComponent,
    GestoniaireAddComponent,
    GestoniaireListComponent,
    FormateurListComponent,
    FormateurAddComponent,
    FormateurDetailComponent
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
    GrowlModule
  ],

  providers: [Globals, IncidentService, DatePipe, EnseignementService, FormateurService,
    GestionnaireService, MatiereService, OrdinateurService, ProjecteurService, SalleService, StagiaireService, TechnicienService],

  bootstrap: [AppComponent]
})

export class AppModule {
}
