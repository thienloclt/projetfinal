import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Globals} from '../../../framework/globals';
import {ProjecteurService} from '../../../service/projecteur.service';
import {Projecteur} from '../../../model/projecteur.model';

@Component({
  selector: 'app-projecteur-add',
  templateUrl: './projecteur-add.component.html',
  styleUrls: ['./projecteur-add.component.css']
})
export class ProjecteurAddComponent implements OnInit {
  id: number;
  myForm: FormGroup;
  formsubmitted: boolean = false;


  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
              private objService: ProjecteurService) {


    this.route.params.subscribe(param => {
      this.id = param['id'];
    });


    this.myForm = this.fb.group({
      'id': [''],
      'code': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'nom': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'coutJournalier': ['']
    });
  }


  ngOnInit() {
    if (this.id) {
    }
  }


  onSubmit() {
    this.formsubmitted = true;


    if (this.myForm.valid) {
      let obj: Projecteur;
      obj = this.myForm.value;



      if (this.id) {
      } else {
        this.objService.add(obj).subscribe(val => {
          this.router.navigateByUrl('/projecteur');
        });
      }
    }
  }
}
