import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router, Routes} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Globals} from '../../framework/globals';
import {UserTestService} from '../../service/usertest.service';

@Component({
  selector: 'app-usertest-add',
  templateUrl: './usertest-add.component.html',
  styleUrls: ['./usertest-add.component.css']
})
export class UserTestAddComponent implements OnInit {
  id: number;
  monform: FormGroup;
  formsubmitted: boolean = false;
  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
              private usertestService: UserTestService) {
    route.params.subscribe(param => {
      this.id = param['id'];
    });
    this.monform = this.fb.group({
      'id': [''],
      'passwrd': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'email': ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.email])]
    });
  }

  ngOnInit() {
    if (this.id) {
      this.usertestService.get(this.id).subscribe(usertestFromREST => {
        this.monform.controls['id'].setValue(usertestFromREST.id);
        this.monform.controls['passwrd'].setValue(usertestFromREST.passwrd);
        this.monform.controls['email'].setValue(usertestFromREST.email);
      });
    }
  }

  onSubmit() {
    console.log(this.monform.value);
    this.formsubmitted = true;
    if(this.monform.valid){
      if (this.id) {
        this.usertestService.update(this.monform.value).subscribe(val => {
          this.router.navigateByUrl('/usertest');
        });
      }
      else {
        this.usertestService.add(this.monform.value).subscribe(val => {
          this.router.navigateByUrl('/usertest');
        });
      }
    }
  }
}
