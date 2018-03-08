import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Globals} from '../../../framework/globals';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {FormationService} from '../../../service/formation.service';
import {Formation} from '../../../model/formation.model';
import {GestionnaireService} from '../../../service/gestionnaire.service';
import {Gestionnaire} from '../../../model/gestionnaire.model';
import {Salle} from '../../../model/salle.model';

@Component({
  selector: 'app-formation-add',
  templateUrl: './formation-add.component.html',
  styleUrls: ['./formation-add.component.css']
})
export class FormationAddComponent implements OnInit {

  @Output() eventemitter: EventEmitter<string> = new EventEmitter<string>();

  myForm: FormGroup;
  formsubmitted: boolean = false;

  display: boolean = false;

  id: number;
  obj: Formation;
  gestionnaires: Gestionnaire[];

  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
              private objService: FormationService, private gestionnaireService: GestionnaireService) {
    this.myForm = this.fb.group({
      'id': [null],
      'titre': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'dateDebut': ['', Validators.compose([Validators.required])],
      'dateFin': [null],
      'gestionnaire': [null]
    });
  }

  ngOnInit() {

  }

  loadData() {
    this.gestionnaireService.list().subscribe(objsFromREST => {
      this.gestionnaires = objsFromREST;
    });

    if (this.id) {
      this.objService.get(this.id).subscribe(objFromREST => {
        this.obj = objFromREST;
        console.log(this.obj);
        this.myForm.controls['titre'].setValue(this.obj.titre);
        this.myForm.controls['dateDebut'].setValue(this.obj.dateDebut);
        this.myForm.controls['dateFin'].setValue(this.obj.dateFin);
        this.myForm.controls['gestionnaire'].setValue(this.obj.gestionnaire);
      });
    }
  }

  showDialog() {
    this.loadData();
    this.display = true;
  }

  onSubmit() {
    this.formsubmitted = true;

    if (this.myForm.valid) {
      let obj: Formation;
      obj = this.myForm.value;

      if (this.id) {
        obj.id = this.id;
        this.objService.update(obj).subscribe();
      }
      else {
        this.objService.add(obj).subscribe();
      }
      this.eventemitter.emit('tranfere');
      this.display = false;
    }
  }

  onCancel() {
    this.display = false;
  }

  equalsObj(o1: Salle, o2: Salle) {
    if (o1 == null || o2 == null)
      return false;
    return o1.id === o2.id;
  }
}
