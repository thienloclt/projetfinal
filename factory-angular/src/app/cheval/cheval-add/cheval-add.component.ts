import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Globals} from '../../framework/globals';
import {CentreEquestreService} from '../../service/centreequestre.service';
import {ChevalService} from '../../service/cheval.service';
import {CentreEquestre} from '../../model/centreequestre.model';
import {Cheval} from '../../model/cheval.model';

@Component({
  selector: 'app-cheval-add',
  templateUrl: './cheval-add.component.html',
  styleUrls: ['./cheval-add.component.css']
})
export class ChevalAddComponent implements OnInit {
  id: number;
  myForm: FormGroup;
  formsubmitted: boolean = false;
  centreequestres: Array<CentreEquestre> = [];
  centreequestreSelected: CentreEquestre;
  centreequestresSelected: Array<CentreEquestre> = [];

  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
              private chevalService: ChevalService, private centreequestreService: CentreEquestreService) {

    console.log('11111111111');
    this.route.params.subscribe(param => {
      this.id = param['id'];
    });

    this.centreequestreService.list().subscribe(centreequestresFromREST => {
      this.centreequestres = centreequestresFromREST;

      console.log(this.centreequestresSelected.length);
      this.centreequestresSelected.push(this.centreequestres[0]);
      this.centreequestresSelected.push(this.centreequestres[1]);

      console.log(this.centreequestresSelected.length);
      for (let i = 0; i < this.centreequestresSelected.length; i++) {
        console.log(this.centreequestresSelected[i].nom);
      }
    });

    this.myForm = this.fb.group({
      'id': [''],
      'nom': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'remarque': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'centreEquestre': ['']
    });

  }

  ngOnInit() {
    console.log('2222222222');
    if (this.id) {
      this.chevalService.get(this.id).subscribe(chevalFromREST => {
        this.myForm.controls['id'].setValue(chevalFromREST.id);
        this.myForm.controls['nom'].setValue(chevalFromREST.nom);
        this.myForm.controls['remarque'].setValue(chevalFromREST.remarque);
        this.myForm.controls['centreEquestre'].setValue(chevalFromREST.centreEquestre);

        this.centreequestreSelected = chevalFromREST.centreEquestre;

        //console.log('**************************');
        //console.log(this.centreequestreSelected.nom);
        //this.centreequestresSelected[0] = (this.centreequestreSelected);
        //this.centreequestresSelected.push(this.centreequestres[0]);

      });
    }
  }

  onSubmit() {
    this.formsubmitted = true;

    if (this.myForm.valid) {
      let cheval: Cheval;
      cheval  = this.myForm.value;

      let centreEquestres: CentreEquestre[];
      centreEquestres = this.myForm.controls['centreEquestre'].value;
      for (let i = 0; i < centreEquestres.length; i++) {
      }

      //     let centreEquestres: CentreEquestre[];
 //     centreEquestres = this.centreequestres.filter(value => value.id === parseInt(this.myForm.controls['centreEquestre'].value));
 //     cheval.centreEquestre = centreEquestres[0];

      cheval.centreEquestre = this.myForm.controls['centreEquestre'].value;
/*
      if (this.id) {
        this.chevalService.update(cheval).subscribe(val => {
          this.router.navigateByUrl('/cheval');
        });
      } else {
        this.chevalService.add(this.myForm.value).subscribe(val => {
          this.router.navigateByUrl('/cheval');
        });
      }*/
    }
  }

  equalsCentreEquestre(o1: CentreEquestre, o2: CentreEquestre) {
    if (o1 == null || o2 == null)
      return false;
    return o1.id === o2.id;
  }
}
