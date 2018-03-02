import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Globals} from '../../../framework/globals';
import {ActivatedRoute, Router} from '@angular/router';
import {OrdinateurService} from '../../../service/ordinateur.service';
import {Ordinateur} from '../../../model/ordinateur.model';



@Component({
  selector: 'app-ordinateur-add',
  templateUrl: './ordinateur-add.component.html',
  styleUrls: ['./ordinateur-add.component.css']
})
export class OrdinateurAddComponent implements OnInit {
  id: number;
  myForm: FormGroup;
  formsubmitted: boolean = false;

  cars: ['aaaaa', 'bbbb', 'ccccc'];

  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
              private objService: OrdinateurService) {

    this.route.params.subscribe(param => {
      this.id = param['id'];
    });

    this.myForm = this.fb.group({
      'id': [''],
      'titre': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
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
      let obj: Ordinateur;
      obj = this.myForm.value;

      console.log(obj);
      console.log(this.cars);
      if (this.id) {
      } else {
        this.objService.add(obj).subscribe(val => {
          this.router.navigateByUrl('/ordinateur');
        });
      }
    }
  }
}
