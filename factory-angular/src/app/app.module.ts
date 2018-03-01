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
import { ChevalService} from './service/cheval.service';
import { CentreEquestreService} from './service/centreequestre.service';
import { UserTestService} from './service/usertest.service';
import { IncidentService} from './service/incident.service';

import { AppComponent } from './app.component';
import { HeaderComponent } from './framework/header/header.component';
import { FooterComponent } from './framework/footer/footer.component';
import { MenuComponent } from './framework/menu/menu.component';
import { DashboardComponent } from './framework/dashboard/dashboard.component';

import { ChevalListComponent } from './cheval/cheval-list/cheval-list.component';
import { ChevalListChildComponent } from './cheval/cheval-list-child/cheval-list-child.component';
import { ChevalAddComponent } from './cheval/cheval-add/cheval-add.component';
import { ChevalDetailComponent } from './cheval/cheval-detail/cheval-detail.component';

import { UserTestListComponent} from './usertest/usertest-list/usertest-list.component';
import { UserTestListChildComponent} from './usertest/usertest-list-child/usertest-list-child.component';
import { UserTestAddComponent} from './usertest/usertest-add/usertest-add.component';
import { UserTestDetailComponent} from './usertest/usertest-detail/usertest-detail.component';

import { TestbootstrapComponent} from './testbootstrap/testbootstrap.component';

import { IncidentListComponent} from './incident/incident-list/incident-list.component';
import { IncidentListChildComponent} from './incident/incident-list-child/incident-list-child.component';
import { IncidentAddComponent} from './incident/incident-add/incident-add.component';
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
  {path: 'cheval', component: ChevalListComponent},
  {path: 'cheval/:id', component: ChevalDetailComponent},
  {path: 'cheval-add', component: ChevalAddComponent},
  {path: 'cheval-edit/:id', component: ChevalAddComponent},
  {path: 'usertest', component: UserTestListComponent},
  {path: 'usertest/:id', component: UserTestDetailComponent},
  {path: 'usertest-add', component: UserTestAddComponent},
  {path: 'usertest-edit/:id', component: UserTestAddComponent},
  {path: 'incident', component: IncidentListComponent},
  {path: 'incident-add', component: IncidentAddComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    MenuComponent,
    DashboardComponent,
    ChevalListComponent,
    ChevalListChildComponent,
    ChevalAddComponent,
    ChevalDetailComponent,
    UserTestListComponent,
    UserTestListChildComponent,
    UserTestAddComponent,
    UserTestDetailComponent,
    IncidentListComponent,
    IncidentListChildComponent,
    IncidentAddComponent,
    TestbootstrapComponent,
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
  providers: [Globals, ChevalService, CentreEquestreService, UserTestService, IncidentService, DatePipe, EnseignementService, FormateurService,
    GestionnaireService, MatiereService, OrdinateurService, ProjecteurService, SalleService, StagiaireService, TechnicienService],
  bootstrap: [AppComponent]
})

export class AppModule {
}
