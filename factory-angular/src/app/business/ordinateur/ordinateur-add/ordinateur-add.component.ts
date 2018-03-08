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



  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
              private objService: OrdinateurService) {

    this.route.params.subscribe(param => {
      this.id = param['id'];
    });

    this.myForm = this.fb.group({
      'id': [''],
      'code': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'nom': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'coutJournalier': [''],
      'processeur': [''],
      'disqueDur': [''],
      'ram': [''],
      'anneeAchat': ['']
    });
  }

  ngOnInit() {

    if (this.id) {
    }
  }

  onSubmit() {
    this.formsubmitted = true;

    if (this.myForm.valid) {
      let obj: Ordinateur;
      obj = this.myForm.value;



      if (this.id) {
        obj.id = this.id;
        this.objService.update(obj).subscribe(val => {

          this.router.navigateByUrl('/ordinateur');
        });
      } else {
        this.objService.add(obj).subscribe(val => {
          this.router.navigateByUrl('/ordinateur');
        });
      }
    }
  }
}
