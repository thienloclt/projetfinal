import { Component, OnInit } from '@angular/core';
import {Globals} from '../../../framework/globals';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {FormateurService} from '../../../service/formateur.service';

import {EnseignementService} from '../../../service/enseignement.service';
import {Formateur} from '../../../model/formateur.model';
import {Matiere} from '../../../model/matiere.model';
import {MatiereService} from '../../../service/matiere.service';
import {Enseignement} from '../../../model/enseignement.model';
import {Formation} from '../../../model/formation.model';
import {FormationService} from '../../../service/formation.service';
import {ConfirmationService} from 'primeng/api';
import {AllocationService} from '../../../service/allocation.service';


@Component({
  selector: 'app-enseignement-detail',
  templateUrl: './enseignement-detail.component.html',
  styleUrls: ['./enseignement-detail.component.css']
})
export class EnseignementDetailComponent implements OnInit {

  id: number;
  obj = new Enseignement();
  formsubmitted: boolean = false;

  enseignement: Enseignement;


  formateur:Formateur;
  formateurs: Array<Formateur> = [];

  matiere: Matiere;
  matieres: Array<Matiere> = [];

  constructor(public globals: Globals, private route: ActivatedRoute, private router: Router, private objService: EnseignementService, private allocationService: AllocationService, private confirmationService: ConfirmationService) {
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
            this.router.navigateByUrl('/formation');
          });
        },
        reject: () => {
        }
      });
    }

    getObj() {
      this.objService.get(this.id).subscribe(objFromREST => {
        this.obj = objFromREST;

      });
    }

    getFromChild(event) {
      this.getObj();
    }
  }
