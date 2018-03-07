import { Component, OnInit } from '@angular/core';
import {ConfirmationService} from 'primeng/api';
import {Globals} from '../../../framework/globals';

import {ActivatedRoute, Router} from '@angular/router';
import {Salle} from '../../../model/salle.model';
import {SalleService} from '../../../service/salle.service';
import {ProgrammeService} from '../../../service/programme.service';

import {Formation} from '../../../model/formation.model';
import {FormationService} from '../../../service/formation.service';

@Component({
  selector: 'app-salle-detail',
  templateUrl: './salle-detail.component.html',
  styleUrls: ['./salle-detail.component.css']
})
export class SalleDetailComponent implements OnInit {
  id: number;
  obj = new Salle();

  formations: Array<Formation> = [];
formation


  constructor(public globals: Globals, private route: ActivatedRoute, private router: Router, private objService: SalleService
              , private programmeService: ProgrammeService, private formationService:FormationService, private confirmationService: ConfirmationService) {
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
      this.programmeService.getByFormation(this.id).subscribe(objsFromREST => {
        this.obj.formations = objsFromREST;
      });

      console.log(this.obj);
    });
  }

  getFromChild(event) {
    this.getObj();
  }
}
