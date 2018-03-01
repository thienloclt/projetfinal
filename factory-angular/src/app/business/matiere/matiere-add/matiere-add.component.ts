import { Component, OnInit } from '@angular/core';
import {Matiere} from '../../../model/matiere.model';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatiereService} from '../../../service/matiere.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Globals} from '../../../framework/globals';
import {Message} from 'primeng/api';

@Component({
  selector: 'app-matiere-add',
  templateUrl: './matiere-add.component.html',
  styleUrls: ['./matiere-add.component.css']
})
export class MatiereAddComponent implements OnInit {
  id: number;
  myForm: FormGroup;
  formsubmitted : boolean = false;

  matieres: Array<Matiere> = [];


  val1 = 0;
  msgs: Message[];

  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
             private matiereService: MatiereService) {

    this.route.params.subscribe(param => {
      this.id = param['id'];
    });

    this.myForm = this.fb.group({
      'id': [''],
      'nom': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'couleur': ['', Validators.compose([Validators.required, Validators.minLength(3)])]
    });

  }

  ngOnInit() {
    if (this.id) {
    }
  }

  onSubmit() {
    this.formsubmitted = true;

    if (this.myForm.valid) {
      let matiere: Matiere;
      matiere  = this.myForm.value;

      if (this.id) {
      } else {
        this.matiereService.add(matiere).subscribe(val => {
          this.msgs = [];
          this.msgs.push({ severity: 'info', summary: 'Matiere Added', detail: 'Saved!!!' });
          this.router.navigateByUrl('/matiere');
        });
      }
    }
  }
}
