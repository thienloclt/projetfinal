import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Globals} from '../../../framework/globals';

import {FormateurService} from '../../../service/formateur.service';
import {Formateur} from '../../../model/formateur.model';
import {Enseignement} from '../../../model/enseignement.model';


@Component({
  selector: 'app-formateur-add',
  templateUrl: './formateur-add.component.html',
  styleUrls: ['./formateur-add.component.css']
})
export class FormateurAddComponent implements OnInit {
enseignements:Set<Enseignement>;
  id: number;
  myForm: FormGroup;
  formsubmitted: boolean = false;


  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
              private objService: FormateurService) {


    this.route.params.subscribe(param => {
      this.id = param['id'];
    });


    this.myForm = this.fb.group({
      'id': [''],
      'nom': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'prenom': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'competence': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'dateNaissance': [''],
      'adresse': [''],
      'email': ['', Validators.compose([Validators.email])],
      'numTel': ['']
      // 'enseignements': [''],
      // 'programmes': ['']
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


      /*      let centreEquestres: CentreEquestre[];
        centreEquestres = this.myForm.controls['centreEquestre'].value;
        for (let i = 0; i < centreEquestres.length; i++) {
        }*/


      //     let centreEquestres: CentreEquestre[];
      //     centreEquestres = this.centreequestres.filter(value => value.id === parseInt(this.myForm.controls['centreEquestre'].value));
      //     cheval.centreEquestre = centreEquestres[0];

      //incident.centreEquestre = this.myForm.controls['centreEquestre'].value;

      console.log(obj);
      if (this.id) {
      } else {
        this.objService.add(obj).subscribe(val => {

          this.router.navigateByUrl('/formateur');
        });
      }
    }
  }
}
