import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Globals} from '../../../framework/globals';
import {TechnicienService} from '../../../service/technicien.service';
import {Technicien} from '../../../model/technicien.model';

@Component({
  selector: 'app-technicien-add',
  templateUrl: './technicien-add.component.html',
  styleUrls: ['./technicien-add.component.css']
})
export class TechnicienAddComponent implements OnInit {

  id: number;
  myForm: FormGroup;
  formsubmitted: boolean = false;


  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
              private objService: TechnicienService) {


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
    });
  }


  ngOnInit() {
    if (this.id) {
    }
  }


  onSubmit() {
    this.formsubmitted = true;


    if (this.myForm.valid) {
      let obj: Technicien;
      obj = this.myForm.value;


      /*      let centreEquestres: CentreEquestre[];
        centreEquestres = this.myForm.controls['centreEquestre'].value;
        for (let i = 0; i < centreEquestres.length; i++) {
        }*/


      //     let centreEquestres: CentreEquestre[];
      //     centreEquestres = this.centreequestres.filter(value => value.id === parseInt(this.myForm.controls['centreEquestre'].value));
      //     cheval.centreEquestre = centreEquestres[0];

      //incident.centreEquestre = this.myForm.controls['centreEquestre'].value;

      if (this.id) {
      } else {
        this.objService.add(obj).subscribe(val => {
          this.router.navigateByUrl('/technicien');
        });
      }
    }
  }
}
