import {Component, OnInit } from '@angular/core';
import {Globals} from '../../../framework/globals';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {FormationService} from '../../../service/formation.service';
import {Formation} from '../../../model/formation.model';
import {GestionnaireService} from '../../../service/gestionnaire.service';
import {Gestionnaire} from '../../../model/gestionnaire';

@Component({
  selector: 'app-formation-add',
  templateUrl: './formation-add.component.html',
  styleUrls: ['./formation-add.component.css']
})
export class FormationAddComponent implements OnInit {
  id: number;
  myForm: FormGroup;
  formsubmitted: boolean = false;

  gestionnaires: Array<Gestionnaire> = [];
  selectedGestionnaire = Gestionnaire;

  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
              private objService: FormationService, private gestionnaireService: GestionnaireService) {

    this.route.params.subscribe(param => {
      this.id = param['id'];
    });

    this.gestionnaireService.list().subscribe(objsFromREST => {
      this.gestionnaires = objsFromREST;
    });

    this.myForm = this.fb.group({
      'id': [null],
      'titre': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'dateDebut': ['', Validators.compose([Validators.required])],
      'dateFin': ['', Validators.compose([Validators.required])],
      'gestionnaire': [null]
    });
  }

  ngOnInit() {
    if (this.id) {
    }
  }

  onSubmit() {
    this.formsubmitted = true;

    if (this.myForm.valid) {
      let obj: Formation;
      obj = this.myForm.value;

      console.log(obj);
      if (this.id) {
      } else {
        this.objService.add(obj).subscribe(val => {
          this.router.navigateByUrl('/formation');
        });
      }
    }
  }
}
