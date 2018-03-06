import { Component, OnInit } from '@angular/core';
import {Globals} from '../../../framework/globals';
import {ActivatedRoute, Router} from '@angular/router';
import {FormationService} from '../../../service/formation.service';
import {Formation} from '../../../model/formation.model';
import {ConfirmationService} from 'primeng/api';
import {AllocationService} from '../../../service/allocation.service';
import {ProgrammeService} from '../../../service/programme.service';

@Component({
  selector: 'app-formation-detail',
  templateUrl: './formation-detail.component.html',
  styleUrls: ['./formation-detail.component.css']
})

export class FormationDetailComponent implements OnInit {
  id: number;
  obj = new Formation();

  constructor(public globals: Globals, private route: ActivatedRoute, private router: Router, private objService: FormationService, private allocationService: AllocationService, private programmeService: ProgrammeService, private confirmationService: ConfirmationService) {
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
      this.allocationService.getByFormation(this.id).subscribe(objsFromREST => {
        this.obj.allocations = objsFromREST;
      });

      this.programmeService.getByFormation(this.id).subscribe(objsFromREST => {
        this.obj.programmes = objsFromREST;
      });
      console.log(this.obj);
    });
  }

  getFromChild(event) {
    this.getObj();
  }
}
