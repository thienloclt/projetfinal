import { Component, OnInit } from '@angular/core';

import {Globals} from '../../../framework/globals';
import {ActivatedRoute, Router} from '@angular/router';

import {ConfirmationService} from 'primeng/api';
import {Gestionnaire} from '../../../model/gestionnaire.model';
import {GestionnaireService} from '../../../service/gestionnaire.service';
import {ProgrammeService} from '../../../service/programme.service';

@Component({
  selector: 'app-gestionnaire-detail',
  templateUrl: './gestionnaire-detail.component.html',
  styleUrls: ['./gestionnaire-detail.component.css']
})
export class GestionnaireDetailComponent implements OnInit {
  id: number;
  obj = new Gestionnaire();

  constructor(public globals: Globals, private route: ActivatedRoute, private router: Router, private objService: GestionnaireService,
              private programmeService: ProgrammeService, private confirmationService: ConfirmationService) {
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
          this.router.navigateByUrl('/gestionnaire');
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
    });
  }

  getFromChild(event) {
    this.getObj();
  }
}
