import { Component, OnInit } from '@angular/core';
import {Globals} from '../../../framework/globals';
import {ActivatedRoute, Router} from '@angular/router';

import {ConfirmationService} from 'primeng/api';

import {Formateur} from '../../../model/formateur.model';
import {FormateurService} from '../../../service/formateur.service';
import {ProgrammeService} from '../../../service/programme.service';


@Component({
  selector: 'app-formateur-detail',
  templateUrl: './formateur-detail.component.html',
  styleUrls: ['./formateur-detail.component.css']
})
export class FormateurDetailComponent implements OnInit {
  id: number;
  obj = new Formateur();

  constructor(public globals: Globals, private route: ActivatedRoute, private router: Router, private objService: FormateurService, private programmeService: ProgrammeService, private confirmationService: ConfirmationService) {
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
          this.router.navigateByUrl('/formateur');
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





