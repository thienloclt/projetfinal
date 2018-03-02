import {Component, Input, OnInit} from '@angular/core';
import {ProjecteurService} from '../../../service/projecteur.service';
import {Globals} from '../../../framework/globals';
import {Projecteur} from '../../../model/projecteur.model';
import {FormationService} from '../../../service/formation.service';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Salle} from '../../../model/salle.model';
import {SalleService} from '../../../service/salle.service';
import {Stagiaire} from '../../../model/stagiaire';
import {StagiaireService} from '../../../service/stagiaire.service';

@Component({
  selector: 'app-formation-add-stagiaire',
  templateUrl: './formation-add-stagiaire.component.html',
  styleUrls: ['./formation-add-stagiaire.component.css']
})
export class FormationAddStagiaireComponent implements OnInit {

  @Input() id: number;
  display: boolean = false;

  myForm: FormGroup;
  formsubmitted: boolean = false;
  salles: Array<Salle> = [];
  projecteurs: Array<Projecteur> = [];
  selectedSalle: Salle;
  selectedProjecteur: Projecteur;

  sourceStagiaires: Stagiaire[] = [];
  targetStagiaires: Stagiaire[] = [];


  sourceCars: String[];

  targetCars: String[];

  constructor(public globals: Globals, private fb: FormBuilder, private objService: StagiaireService) {
    this.objService.list().subscribe(objsFromREST => {
      this.sourceStagiaires = objsFromREST;
      this.targetStagiaires = [];
    });

    this.myForm = this.fb.group({
      'id': [''],
      'salle': [''],
      'projecteur': ['']
    });
  }

  ngOnInit() {
    /*    if (this.id) {
          this.objService.get(this.id).subscribe(objFromREST => {
            this.myForm.controls['id'].setValue(objFromREST.id);
            this.myForm.controls['salle'].setValue(objFromREST.salle);
            this.myForm.controls['projecteur'].setValue(objFromREST.projecteur);
          });
        }*/
  }

  showDialog() {
    this.display = true;
  }

  OKDialog() {
    console.log('OK');
    this.display = false;
  }

  CancelDialog() {
    console.log('cancel');
    this.display = false;
  }
}
