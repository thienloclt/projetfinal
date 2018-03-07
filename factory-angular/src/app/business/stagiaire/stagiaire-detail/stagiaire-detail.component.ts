import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ConfirmationService} from 'primeng/api';
import {AllocationService} from '../../../service/allocation.service';
import {Globals} from '../../../framework/globals';
import {Stagiaire} from '../../../model/stagiaire.model';
import {StagiaireService} from '../../../service/stagiaire.service';

@Component({
  selector: 'app-stagiaire-detail',
  templateUrl: './stagiaire-detail.component.html',
  styleUrls: ['./stagiaire-detail.component.css']
})
export class StagiaireDetailComponent implements OnInit {

  id: number;
  obj = new Stagiaire();

  constructor(public globals: Globals, private route: ActivatedRoute, private router: Router, private objService: StagiaireService, private allocationService: AllocationService, private confirmationService: ConfirmationService) {
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
          this.router.navigateByUrl('/stagiaire');
        });
      },
      reject: () => {
      }
    });
  }

  getObj() {
    this.objService.get(this.id).subscribe(objFromREST => {
      this.obj = objFromREST;
      this.allocationService.getStagiairesByFormation(this.id).subscribe(objsFromREST => {
        console.log('getObj');
        this.obj.formations = objsFromREST;
      });
    });
  }

  getFromParent(event) {
    this.getObj();
  }
}
