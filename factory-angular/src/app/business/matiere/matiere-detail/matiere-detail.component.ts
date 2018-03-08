import { Component, OnInit } from '@angular/core';
import {ConfirmationService} from 'primeng/api';
import {Globals} from '../../../framework/globals';
import {ActivatedRoute, Router} from '@angular/router';

import {ProgrammeService} from '../../../service/programme.service';
import {Matiere} from '../../../model/matiere.model';
import {Enseignement} from '../../../model/enseignement.model';
import {EnseignementService} from '../../../service/enseignement.service';
import {Programme} from '../../../model/programme.model';
import {Formation} from '../../../model/formation.model';
import {FormateurService} from '../../../service/formateur.service';
import {MatiereService} from '../../../service/matiere.service';

@Component({
  selector: 'app-matiere-detail',
  templateUrl: './matiere-detail.component.html',
  styleUrls: ['./matiere-detail.component.css']
})
export class MatiereDetailComponent implements OnInit {
  id: number;
  obj = new Matiere();
couleur:string;
  enseignements: Array<Enseignement> = [];

  programmes:Array<Programme> = [];

  formations:Array<Formation> = [];

  constructor(public globals: Globals, private route: ActivatedRoute, private router: Router, private objService: MatiereService
    , private programmeService: ProgrammeService, private enseignementService:EnseignementService,
              private formationService: FormateurService, private confirmationService: ConfirmationService) {
  }

  ngOnInit() {
    this.route.params.subscribe(param => {
      this.id = param['id'];
      this.getObj();
    });
  }

  deleteObj() {
    this.confirmationService.confirm({
      message: 'Do you want to delete this record?',
      header: 'Delete Confirmation',
      icon: 'fa fa-trash',
      accept: () => {
        this.objService.delete(this.id).subscribe( value => {
          this.router.navigateByUrl('/salle');
        });
      },
      reject: () => {
      }
    });
  }

  getObj() {
    this.objService.get(this.id).subscribe(objFromREST => {
      this.obj = objFromREST;

      console.log(this.obj);
    });
  }

  getFromChild(event) {
    this.getObj();
  }
}
