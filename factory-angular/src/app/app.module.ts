import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { RouterModule, Routes} from '@angular/router';
import { DatePipe} from '@angular/common';
import { NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { TableModule} from 'primeng/table';
import {CalendarModule, ConfirmDialogModule, DropdownModule, OrderListModule, PickListModule, ProgressBarModule} from 'primeng/primeng';
import { SliderModule} from 'primeng/slider';
import { GrowlModule} from 'primeng/growl';
import { BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ConfirmationService} from 'primeng/api';


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
import { FormationAddComponent } from './business/formation/formation-add/formation-add.component';
import { FormationListComponent } from './business/formation/formation-list/formation-list.component';
import { FormationDetailComponent } from './business/formation/formation-detail/formation-detail.component';


import { Globals} from './framework/globals';
import { IncidentService} from './service/incident.service';
import { EnseignementService} from './service/enseignement.service';
import { FormateurService} from './service/formateur.service';
import { GestionnaireService} from './service/gestionnaire.service';
import { MatiereService} from './service/matiere.service';
import { OrdinateurService} from './service/ordinateur.service';
import { ProjecteurService} from './service/projecteur.service';
import { SalleService} from './service/salle.service';
import { FormationService} from './service/formation.service';
import { StagiaireService} from './service/stagiaire.service';
import { TechnicienService} from './service/technicien.service';
import {DialogModule} from 'primeng/dialog';
import { FormationAddChildComponent } from './business/formation/formation-add-child/formation-add-child.component';
import {FormateurAddComponent} from './business/formateur/formateur-add/formateur-add.component';
import {FormateurListComponent} from './business/formateur/formateur-list/formateur-list.component';
import {FormateurDetailComponent} from './business/formateur/formateur-detail/formateur-detail.component';
import {GestionnaireAddComponent} from './business/gestionnaire/gestionnaire-add/gestionnaire-add.component';
import {GestionnaireListComponent} from './business/gestionnaire/gestionnaire-list/gestionnaire-list.component';
import {GestionnaireDetailComponent} from './business/gestionnaire/gestionnaire-detail/gestionnaire-detail.component';
import {OrdinateurDetailComponent} from './business/ordinateur/ordinateur-detail/ordinateur-detail.component';
import {OrdinateurListComponent} from './business/ordinateur/ordinateur-list/ordinateur-list.component';
import {ProjecteurAddComponent} from './business/projecteur/projecteur-add/projecteur-add.component';
import {ProjecteurListComponent} from './business/projecteur/projecteur-list/projecteur-list.component';
import {ProjecteurDetailComponent} from './business/projecteur/projecteur-detail/projecteur-detail.component';
import {StagiaireAddComponent} from './business/stagiaire/stagiaire-add/stagiaire-add.component';
import {StagiaireListComponent} from './business/stagiaire/stagiaire-list/stagiaire-list.component';
import {StagiaireDetailComponent} from './business/stagiaire/stagiaire-detail/stagiaire-detail.component';
import {TechnicienDetailComponent} from './business/technicien/technicien-detail/technicien-detail.component';
import {TechnicienAddComponent} from './business/technicien/technicien-add/technicien-add.component';
import {TechnicienListComponent} from './business/technicien/technicien-list/technicien-list.component';
import { MatiereDetailComponent } from './business/matiere/matiere-detail/matiere-detail.component';
import { EnseignementDetailComponent } from './business/enseignement/enseignement-detail/enseignement-detail.component';
import { EnseignementAddComponent } from './business/enseignement/enseignement-add/enseignement-add.component';
import { EnseignementListComponent } from './business/enseignement/enseignement-list/enseignement-list.component';
import { FormationAddStagiaireComponent } from './business/formation/formation-add-stagiaire/formation-add-stagiaire.component';
import {FormationAddMaterielComponent} from './business/formation/formation-add-materiel/formation-add-materiel.component';
import {ProgrammeService} from './service/programme.service';
import {AllocationService} from './service/allocation.service';
import { FormationAddMatiereComponent } from './business/formation/formation-add-matiere/formation-add-matiere.component';


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
  {path: 'formation', component: FormationListComponent},
  {path: 'formation-add', component: FormationAddComponent},
  {path: 'formation-edit/:id', component: FormationAddComponent},
  {path: 'formation/:id', component: FormationDetailComponent},
  {path: 'gestionnaire', component: GestionnaireListComponent},
  {path: 'gestionnaire-add', component: GestionnaireAddComponent},
  {path: 'gestionnaire-edit/:id', component: GestionnaireAddComponent},
  {path: 'gestionnaire/:id', component: GestionnaireDetailComponent},
  {path: 'formateur', component: FormateurListComponent},
  {path: 'formateur-add', component: FormateurAddComponent},
  {path: 'formateur-edit/:id', component: FormateurAddComponent},
  {path: 'formateur/:id', component: FormateurDetailComponent},
  {path: 'ordinateur', component: OrdinateurListComponent},
  {path: 'ordinateur-add', component: OrdinateurAddComponent},
  {path: 'ordinateur-edit/:id', component: OrdinateurAddComponent},
  {path: 'ordinateur/:id', component: OrdinateurDetailComponent},
  {path: 'projecteur', component: ProjecteurListComponent},
  {path: 'projecteur-add', component: ProjecteurAddComponent},
  {path: 'projecteur-edit/:id', component: ProjecteurAddComponent},
  {path: 'projecteur/:id', component: ProjecteurDetailComponent},
  {path: 'stagiaire', component: StagiaireListComponent},
  {path: 'stagiaire-add', component: StagiaireAddComponent},
  {path: 'stagiaire-edit/:id', component: StagiaireAddComponent},
  {path: 'stagiaire/:id', component: StagiaireDetailComponent},
  {path: 'technicien', component: TechnicienListComponent},
  {path: 'technicien-add', component: TechnicienAddComponent},
  {path: 'technicien-edit/:id', component: TechnicienAddComponent},
  {path: 'technicien/:id', component: TechnicienDetailComponent},
  {path: 'matiere/:id', component: MatiereDetailComponent},
  {path: 'enseignement', component: EnseignementListComponent},
  {path: 'enseignement-add', component: EnseignementAddComponent},
  {path: 'enseignement-edit/:id', component: EnseignementAddComponent},
  {path: 'enseignement/:id', component: EnseignementDetailComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    MenuComponent,
    DashboardComponent,
    MatiereAddComponent,
    MatiereDetailComponent,
    MatiereListComponent,
    SalleAddComponent,
    SalleListComponent,
    SalleDetailComponent,
    FormationAddComponent,
    OrdinateurAddComponent,
    FormationListComponent,
    FormationDetailComponent,
    FormationAddMaterielComponent,
    FormateurAddComponent,
    FormateurListComponent,
    FormateurDetailComponent
    FormationAddChildComponent
    FormationAddMaterielComponent,
    GestionnaireAddComponent,
    GestionnaireListComponent,
    GestionnaireDetailComponent,
    OrdinateurAddComponent,
    OrdinateurListComponent,
    OrdinateurDetailComponent,
    ProjecteurAddComponent,
    ProjecteurListComponent,
    ProjecteurDetailComponent,
    StagiaireAddComponent,
    StagiaireListComponent,
    StagiaireDetailComponent,.
    TechnicienAddComponent,
    TechnicienListComponent,
    TechnicienDetailComponent,
    EnseignementDetailComponent,
    EnseignementAddComponent,
    EnseignementListComponent,
    FormationAddStagiaireComponent,
    FormationAddMatiereComponent
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
    OrderListModule,
    ConfirmDialogModule,
    DialogModule,
    DropdownModule,
    PickListModule
  ],

  providers: [ConfirmationService, Globals, DatePipe, IncidentService, EnseignementService, FormateurService,
    GestionnaireService, MatiereService, OrdinateurService, ProjecteurService,
    SalleService, StagiaireService, TechnicienService, FormationService],

  bootstrap: [AppComponent]
})

export class AppModule {
}
