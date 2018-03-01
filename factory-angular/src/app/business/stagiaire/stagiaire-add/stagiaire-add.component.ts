import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Globals} from '../../../framework/globals';
import {OrdinateurService} from '../../../service/ordinateur.service';
import {Ordinateur} from '../../../model/ordinateur.model';
import {StagiaireService} from '../../../service/stagiaire.service';
import {Stagiaire} from '../../../model/stagiaire';

@Component({
  selector: 'app-stagiaire-add',
  templateUrl: './stagiaire-add.component.html',
  styleUrls: ['./stagiaire-add.component.css']
})
export class StagiaireAddComponent implements OnInit {

  id: number;
  myForm: FormGroup;
  formsubmitted: boolean = false;


  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
              private objService: StagiaireService) {


    this.route.params.subscribe(param => {
      this.id = param['id'];
    });


    this.myForm = this.fb.group({
      'id': [''],
      'nom': ['', Validators.compose([Validators.required, Validators.minLength(3)])]
    });
  }


  ngOnInit() {
    if (this.id) {
    }
  }


  onSubmit() {
    this.formsubmitted = true;


    if (this.myForm.valid) {
      let obj: Stagiaire;
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
          this.router.navigateByUrl('/stagiaire');
        });
      }
    }
  }
}
