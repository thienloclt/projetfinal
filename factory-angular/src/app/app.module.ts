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

import {IncidentListComponent} from './business/incident/incident-list/incident-list.component';
import {IncidentAddComponent} from './business/incident/incident-add/incident-add.component';
import { MatiereAddComponent } from './business/matiere/matiere-add/matiere-add.component';
import { MatiereListComponent } from './business/matiere/matiere-list/matiere-list.component';
import {MatiereService} from './service/matiere.service';
import { ProgrammeAddComponent } from './programme-add/programme-add.component';
import { SalleAddComponent } from './business/salle/salle-add/salle-add.component';
import { SalleListComponent } from './business/salle/salle-list/salle-list.component';
import { SalleDetailComponent } from './business/salle/salle-detail/salle-detail.component';
import {SalleService} from './service/salle.service';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: DashboardComponent},
  {path: 'matiere', component: MatiereListComponent},
  {path: 'matiere-add', component: MatiereAddComponent},
  {path: 'matiere-edit/:id', component: MatiereAddComponent},
  {path: 'incident', component: IncidentListComponent},
  {path: 'incident-add', component: IncidentAddComponent},
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
    IncidentListComponent,
    IncidentAddComponent,
    MatiereAddComponent,
    MatiereListComponent,
    ProgrammeAddComponent,
    SalleAddComponent,
    SalleListComponent,
    SalleDetailComponent
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
  providers: [Globals, MatiereService, IncidentService, DatePipe, SalleService],
  bootstrap: [AppComponent]
})

export class AppModule {
}
