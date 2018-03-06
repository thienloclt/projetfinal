import { Component, OnInit } from '@angular/core';
import {Couleur, Matiere} from '../../../model/matiere.model';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatiereService} from '../../../service/matiere.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Globals} from '../../../framework/globals';
import {ProgrammeService} from '../../../service/programme.service';
import {EnseignementService} from '../../../service/enseignement.service';
import {Enseignement} from '../../../model/enseignement.model';
import {Programme} from '../../../model/programme.model';

@Component({
  selector: 'app-matiere-add',
  templateUrl: './matiere-add.component.html',
  styleUrls: ['./matiere-add.component.css']
})
export class MatiereAddComponent implements OnInit {
  id: number;
  myForm: FormGroup;
  formsubmitted : boolean = false;

  couleur = Couleur;
  couleurs: any [];

  //matieres: Array<Matiere> = [];

  enseignements: Array<Enseignement> = [];
  selectedEnseignement = Enseignement;

  programmes: Array<Programme> = [];
  selectedProgramme = Programme;


  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
             private objService: MatiereService, private programmeService: ProgrammeService,private enseignementService: EnseignementService) {

    this.route.params.subscribe(param => {
      this.id = param['id'];
    });


    this.enseignementService.list().subscribe(objsFromREST => {
      this.enseignements = objsFromREST;
    });


    this.programmeService.list().subscribe(objsFromREST => {
      this.programmes = objsFromREST;
    });

    this.myForm = this.fb.group({
      'id': [''],
      'nom': ['', Validators.compose([Validators.required])],
      'couleur': ['', Validators.compose([Validators.required])],
      'duree': ['', Validators.compose([Validators.required])],
      'objectif': ['', Validators.compose([Validators.required])],
      'prerequis': ['', Validators.compose([Validators.required])],
      'contenu': ['', Validators.compose([Validators.required])],
      'programmes' : [''],
      'enseignements' : [''],
    });

    this.couleurs = Object.keys(this.couleur).filter(String);
  }

  ngOnInit() {
    if (this.id) {
    }
  }

  onSubmit() {
    this.formsubmitted = true;

    if (this.myForm.valid) {
      let obj: Matiere;
      obj = this.myForm.value;

      if (this.id) {
      } else {
        this.objService.add(obj).subscribe(val => {
          this.router.navigateByUrl('/matiere');
        });
      // } else {
      //   this.matiereService.add(matiere).subscribe(val => {
      //     this.msgs = [];
      //     this.msgs.push({ severity: 'info', summary: 'Matiere Added', detail: 'Saved!!!' });
      //     this.router.navigateByUrl('/matiere');
       // });
      }
    }
  }
}
