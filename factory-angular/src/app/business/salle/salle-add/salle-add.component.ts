import {Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Globals} from '../../../framework/globals';
import {SalleService} from '../../../service/salle.service';
import {Salle} from '../../../model/salle.model';

@Component({
  selector: 'app-salle-add',
  templateUrl: './salle-add.component.html',
  styleUrls: ['./salle-add.component.css']
})

export class SalleAddComponent implements OnInit {
  id: number;
  myForm: FormGroup;
  formsubmitted: boolean = false;

  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
              private objService: SalleService) {

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
      let obj: Salle;
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
          this.router.navigateByUrl('/incident');
        });
      }
    }
  }
}
