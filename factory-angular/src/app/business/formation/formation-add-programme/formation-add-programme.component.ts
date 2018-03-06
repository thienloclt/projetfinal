import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Matiere} from '../../../model/matiere.model';
import {FormationService} from '../../../service/formation.service';
import {MatiereService} from '../../../service/matiere.service';
import {Globals} from '../../../framework/globals';
import {Programme} from '../../../model/programme.model';
import {Formation} from '../../../model/formation.model';
import {ProgrammeService} from '../../../service/programme.service';
import {SalleService} from '../../../service/salle.service';
import {ProjecteurService} from '../../../service/projecteur.service';
import {Salle} from '../../../model/salle.model';
import {Projecteur} from '../../../model/projecteur.model';
import {EnseignementService} from '../../../service/enseignement.service';
import {Enseignement} from '../../../model/enseignement.model';

@Component({
  selector: 'app-formation-add-programme',
  templateUrl: './formation-add-programme.component.html',
  styleUrls: ['./formation-add-programme.component.css']
})
export class FormationAddProgrammeComponent implements OnInit {
  @Input() formation_id: number;
  @Input() programme_id: number;
  @Input() matiere_id: number;
  @Output() eventemitter: EventEmitter<string> = new EventEmitter<string>();

  display: boolean = false;

  myForm: FormGroup;
  formsubmitted: boolean = false;
  programme: Programme;

  enseignements: Array<Enseignement> = [];
  selectedEnseignement: Enseignement;

  constructor(public globals: Globals, private fb: FormBuilder, private objService: FormationService, private enseignementService: EnseignementService, private programmeService: ProgrammeService) {
    this.myForm = this.fb.group({
      'enseignement': [null],
    });

  }

  ngOnInit() {
  }

  loadData() {
    this.programmeService.get(this.programme_id).subscribe(objFromREST => {
      this.programme = objFromREST;
      this.enseignementService.getByMatiereAndOutOfFormation(this.programme.matiere.id, this.programme.formation.id).subscribe(objsFromREST => {
        this.enseignements = objsFromREST;
      });
    });
  }

  showDialog() {
    this.loadData();
    this.display = true;
  }

  onSubmit() {
    let enseignement: Enseignement;
    enseignement = this.myForm.controls['enseignement'].value;
    this.programme.formateur = enseignement.formateur;
    this.programmeService.update(this.programme).subscribe(val => {
      this.eventemitter.emit('tranfere');
      this.display = false;
    });
  }

  onCancel() {
    this.display = false;
  }

  equalsFormateur(o1: Enseignement, o2: Enseignement) {
    if (o1 == null || o2 == null)
      return false;
    return o1.formateur.id === o2.formateur.id;
  }
}