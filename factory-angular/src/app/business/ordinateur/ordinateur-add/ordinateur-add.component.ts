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
           let obj: Ordinateur;
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
                   this.router.navigateByUrl('/ordinateur');
                 });
             }
         }
     }
}
