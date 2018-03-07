import { Component, OnInit } from '@angular/core';
import {ConfirmationService} from 'primeng/api';
import {Globals} from '../../../framework/globals';
import {ActivatedRoute, Router} from '@angular/router';
import {Technicien} from '../../../model/technicien.model';
import {TechnicienService} from '../../../service/technicien.service';

@Component({
  selector: 'app-technicien-detail',
  templateUrl: './technicien-detail.component.html',
  styleUrls: ['./technicien-detail.component.css']
})
export class TechnicienDetailComponent implements OnInit {

  id: number;
  obj = new Technicien();

  constructor(public globals: Globals, private route: ActivatedRoute, private router: Router, private objService: TechnicienService, private confirmationService: ConfirmationService) {
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
          this.router.navigateByUrl('/technicien');
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

  getFromParent(event) {
    this.getObj();
  }
}
