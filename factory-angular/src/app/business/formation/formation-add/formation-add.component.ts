import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Globals} from '../../../framework/globals';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {FormationService} from '../../../service/formation.service';
import {Formation} from '../../../model/formation.model';
import {GestionnaireService} from '../../../service/gestionnaire.service';
import {Gestionnaire} from '../../../model/gestionnaire.model';

@Component({
  selector: 'app-formation-add',
  templateUrl: './formation-add.component.html',
  styleUrls: ['./formation-add.component.css']
})
export class FormationAddComponent implements OnInit {

  @Input() id: number;
  @Output() eventemitter: EventEmitter<string> = new EventEmitter<string>();

  myForm: FormGroup;
  formsubmitted: boolean = false;

  display: boolean = false;

  gestionnaires: Gestionnaire[];

  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
              private objService: FormationService, private gestionnaireService: GestionnaireService) {
  }

  ngOnInit() {

  }

  loadData() {
    this.myForm = this.fb.group({
      'id': [null],
      'titre': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'dateDebut': ['', Validators.compose([Validators.required])],
      'dateFin': [null],
      'gestionnaire': [null]
    });

    this.gestionnaireService.list().subscribe(objsFromREST => {
      this.gestionnaires = objsFromREST;
    });

    if (this.id) {
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
      }
      else {
        this.objService.add(obj).subscribe(val => {
          this.router.navigateByUrl('/formation');
          this.display = false;
        });
      }
    }
  }
}
