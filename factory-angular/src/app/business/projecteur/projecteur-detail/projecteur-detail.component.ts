import { Component, OnInit } from '@angular/core';
import {ConfirmationService} from 'primeng/api';

import {Globals} from '../../../framework/globals';

import {ActivatedRoute, Router} from '@angular/router';
import {ProgrammeService} from '../../../service/programme.service';
import {Projecteur} from '../../../model/projecteur.model';
import {ProjecteurService} from '../../../service/projecteur.service';

@Component({
  selector: 'app-projecteur-detail',
  templateUrl: './projecteur-detail.component.html',
  styleUrls: ['./projecteur-detail.component.css']
})
export class ProjecteurDetailComponent implements OnInit {
  id: number;
  obj = new Projecteur();


  constructor(public globals: Globals, private route: ActivatedRoute, private router: Router, private objService: ProjecteurService,
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
          this.router.navigateByUrl('/projecteur');
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
