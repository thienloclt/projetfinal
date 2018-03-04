import { Component, OnInit } from '@angular/core';

import {Globals} from '../../../framework/globals';
import {ActivatedRoute, Router} from '@angular/router';

import {ConfirmationService} from 'primeng/api';
import {Gestionnaire} from '../../../model/gestionnaire.model';
import {GestionnaireService} from '../../../service/gestionnaire.service';

@Component({
  selector: 'app-gestionnaire-detail',
  templateUrl: './gestionnaire-detail.component.html',
  styleUrls: ['./gestionnaire-detail.component.css']
})
export class GestionnaireDetailComponent implements OnInit {
  id: number;
  obj = Gestionnaire;

  constructor(public globals: Globals, private route: ActivatedRoute, private router: Router, private objService: GestionnaireService, private confirmationService: ConfirmationService) {
    route.params.subscribe(param => {
      this.id = param['id'];
    });
  }

  ngOnInit() {
    this.objService.get(this.id).subscribe(objFromREST => {
      this.obj = objFromREST;
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
}
