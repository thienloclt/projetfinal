import { Component, OnInit } from '@angular/core';
import {Globals} from '../../../framework/globals';
import {ActivatedRoute, Router} from '@angular/router';
import {ConfirmationService} from 'primeng/api';
import {Ordinateur} from '../../../model/ordinateur.model';
import {OrdinateurService} from '../../../service/ordinateur.service';
import {ProgrammeService} from '../../../service/programme.service';


@Component({
  selector: 'app-ordinateur-detail',
  templateUrl: './ordinateur-detail.component.html',
  styleUrls: ['./ordinateur-detail.component.css']
})
export class OrdinateurDetailComponent implements OnInit {
  id: number;
  obj = new Ordinateur();


  constructor(public globals: Globals, private route: ActivatedRoute, private router: Router, private objService: OrdinateurService,
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
