import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Globals} from '../../../framework/globals';
import {GestionnaireService} from '../../../service/gestionnaire.service';
import {Gestionnaire} from '../../../model/gestionnaire';


@Component({
  selector: 'app-gestionnaire-add',
  templateUrl: './gestionnaire-add.component.html',
  styleUrls: ['./gestionnaire-add.component.css']
})
export class GestionnaireAddComponent implements OnInit {

  id: number;
  myForm: FormGroup;
  formsubmitted: boolean = false;


  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
              private objService: GestionnaireService) {


    this.route.params.subscribe(param => {
      this.id = param['id'];
    });


    this.myForm = this.fb.group({
      'id': [''],
      'nom': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'prenom': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'dateNaissance': [''],
      'adresse': [''],
      'email': ['', Validators.compose([Validators.email])],
      'numTel': ['']
      // 'formations': ['']
    });
  }


  ngOnInit() {
    if (this.id) {
    }
  }


  onSubmit() {


    this.formsubmitted = true;


    if (this.myForm.valid) {
      let obj: Gestionnaire;
      obj = this.myForm.value;

      if (this.id) {
      } else {
        this.objService.add(obj).subscribe(val => {
          this.router.navigateByUrl('/stagiaire');
        });
      }
    }
  }
}
