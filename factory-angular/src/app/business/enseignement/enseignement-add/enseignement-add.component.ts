import { Component, OnInit } from '@angular/core';
import {Globals} from '../../../framework/globals';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Formateur} from '../../../model/formateur.model';
import {Enseignement} from '../../../model/enseignement.model';
import {FormateurService} from '../../../service/formateur.service';
import {MatiereService} from '../../../service/matiere.service';
import {Matiere} from '../../../model/matiere.model';
import {EnseignementService} from '../../../service/enseignement.service';
import {Niveau} from '../../../model/niveau.enum';





@Component({
  selector: 'app-enseignement-add',
  templateUrl: './enseignement-add.component.html',
  styleUrls: ['./enseignement-add.component.css']
})
export class EnseignementAddComponent implements OnInit {
  id: number;
  myForm: FormGroup;
  formsubmitted: boolean = false;

  formateurs: Array<Formateur> = [];
  selectedFormateur = Formateur;

  matieres: Array<Matiere> = [];
  selectedMatiere = Matiere;

  niveau = Niveau;
  niveaux: any[];


  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
              private objService: EnseignementService, private matiereService: MatiereService, private formateurService: FormateurService) {

    this.route.params.subscribe(param => {
      this.id = param['id'];
    });

    this.formateurService.list().subscribe(objsFromREST => {
      this.formateurs = objsFromREST;
    });

    this.matiereService.list().subscribe(objsFromREST => {
      this.matieres = objsFromREST;
    });

    this.myForm = this.fb.group({
      'id': [''],
      'niveau': ['', Validators.compose([Validators.required])],
      'formateur': ['', Validators.compose([Validators.required])],
      'matiere': ['', Validators.compose([Validators.required])]

    });

    this.niveaux = Object.keys(this.niveau).filter(String);
  }

  ngOnInit() {
    if (this.id) {
    }
  }

  onSubmit() {
    this.formsubmitted = true;

    if (this.myForm.valid) {
      let obj: Enseignement;
      obj = this.myForm.value;

      console.log(obj);
      if (this.id) {
      } else {
        this.objService.add(obj).subscribe(val => {
          this.router.navigateByUrl('/enseignement');
        });
      }
    }
  }
}
