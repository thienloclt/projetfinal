import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Globals} from '../../../framework/globals';
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
      'nom': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'prenom': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'dateNaissance': [''],
      'adresse': [''],
      'email': ['', Validators.compose([Validators.email])],
      'numTel': ['']
      // 'allocations': ['']
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

      if (this.id) {
      } else {
        this.objService.add(obj).subscribe(val => {
          this.router.navigateByUrl('/stagiaire');
        });
      }
    }
  }
}
