import { Component, OnInit } from '@angular/core';
import {Globals} from '../../../framework/globals';
import {ActivatedRoute, Router} from '@angular/router';
import {FormationService} from '../../../service/formation.service';
import {Formation} from '../../../model/formation.model';
import {ConfirmationService} from 'primeng/api';
import {AllocationService} from '../../../service/allocation.service';
import {ProgrammeService} from '../../../service/programme.service';
import {OrdinateurService} from '../../../service/ordinateur.service';

@Component({
  selector: 'app-formation-detail',
  templateUrl: './formation-detail.component.html',
  styleUrls: ['./formation-detail.component.css']
})

export class FormationDetailComponent implements OnInit {
  id: number;
  formation: Formation = null;

  constructor(public globals: Globals, private route: ActivatedRoute, private router: Router, private formationService: FormationService, private ordinateurService: OrdinateurService, private programmeService: ProgrammeService, private confirmationService: ConfirmationService) {
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
        this.formationService.delete(this.id).subscribe( value => {
          this.router.navigateByUrl('/formation');
        });
      },
      reject: () => {
      }
    });
  }

  getObj() {
    console.log('begin---refreshing-----');
    this.formation = new Formation();
    this.formationService.get(this.id).subscribe(objFromREST => {
      this.formation = objFromREST;
      this.programmeService.getByFormation(this.id).subscribe(objsFromREST => {
        this.formation.programmes = objsFromREST;
      });
      console.log(this.formation);
    });
    console.log('end---refreshing-----');
  }

  getFromChild(event) {
    this.getObj();
  }

  getFromChildOrdinateur(event) {
    this.formation.ordinateurs = null;
    this.ordinateurService.getByFormation(this.id).subscribe(objsFromREST => {
      this.formation.ordinateurs = objsFromREST;
      console.log('getFromChildOrdinateur: ');
      console.log(this.formation);
    });
  }
}
