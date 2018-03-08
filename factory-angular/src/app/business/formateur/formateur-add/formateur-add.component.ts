import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Globals} from '../../../framework/globals';

import {FormateurService} from '../../../service/formateur.service';
import {Formateur} from '../../../model/formateur.model';
import {Enseignement} from '../../../model/enseignement.model';
import {Formation} from '../../../model/formation.model';
import {EnseignementService} from '../../../service/enseignement.service';
import {ProgrammeService} from '../../../service/programme.service';
import {Programme} from '../../../model/programme.model';


@Component({
  selector: 'app-formateur-add',
  templateUrl: './formateur-add.component.html',
  styleUrls: ['./formateur-add.component.css']
})
export class FormateurAddComponent implements OnInit {

  id: number;
  myForm: FormGroup;
  formsubmitted: boolean = false;

  enseignements:Array<Enseignement> = [];
  selectedEnseignement = Enseignement;

  programmes:Array<Programme> = [];
  selectedProgramme = Programme;

  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
              private objService: FormateurService, private enseignementService: EnseignementService, private programmeService: ProgrammeService) {


    this.route.params.subscribe(param => {
      this.id = param['id'];
    });

    this.enseignementService.list().subscribe(objsFromREST => {
      this.enseignements = objsFromREST;
    });

    this.programmeService.list().subscribe(objsFromREST => {
      this.programmes = objsFromREST;
    });

    this.myForm = this.fb.group({
      'id': [''],
      'nom': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'prenom': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'competence': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'titre': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'dateNaissance': [''],
      'adresse': [''],
      'email': ['', Validators.compose([Validators.email])],
      'numTel': [''],
      'enseignement': ['']
    });
  }

  ngOnInit() {
    if (this.id) {
    }
  }


  onSubmit() {
    this.formsubmitted = true;


    if (this.myForm.valid) {
      let obj: Formateur;
      obj = this.myForm.value;



      if (this.id) {
        obj.id = this.id;
        this.objService.update(obj).subscribe(val => {

          this.router.navigateByUrl('/formateur');
        });
      } else {
        this.objService.add(obj).subscribe(val => {

          this.router.navigateByUrl('/formateur');
        });
      }
    }
  }
}
