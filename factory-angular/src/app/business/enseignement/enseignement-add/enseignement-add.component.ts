import { Component, OnInit } from '@angular/core';
import {Globals} from '../../../framework/globals';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {EnseignementService} from '../../../service/enseignement.service';
import {Enseignement} from '../../../model/enseignement';




@Component({
  selector: 'app-enseignement-add',
  templateUrl: './enseignement-add.component.html',
  styleUrls: ['./enseignement-add.component.css']
})
export class EnseignementAddComponent implements OnInit {
  id: number;
  myForm: FormGroup;
  formsubmitted: boolean = false;

  cars: ['aaaaa', 'bbbb', 'ccccc'];

  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
              private objService: EnseignementService) {

    this.route.params.subscribe(param => {
      this.id = param['id'];
    });

    this.myForm = this.fb.group({
      'id': [''],
      'nom': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'dateDebut': ['', Validators.compose([Validators.required])],
      'dateFin': ['', Validators.compose([Validators.required])]
    });
  }

  ngOnInit() {

    this.cars = ['aaaaa', 'bbbb', 'ccccc'];

    if (this.id) {
    }
  }

  onSubmit() {
    this.formsubmitted = true;

    if (this.myForm.valid) {
      let obj: Enseignement;
      obj = this.myForm.value;

      console.log(obj);
      console.log(this.cars);
      if (this.id) {
      } else {
        this.objService.add(obj).subscribe(val => {
          this.router.navigateByUrl('/enseignement');
        });
      }
    }
  }
}
