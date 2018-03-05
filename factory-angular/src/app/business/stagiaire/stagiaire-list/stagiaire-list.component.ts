import { Component, OnInit } from '@angular/core';
import {ConfirmationService, SortEvent} from 'primeng/api';
import {DatePipe} from '@angular/common';
import {Stagiaire} from '../../../model/stagiaire.model';
import {StagiaireService} from '../../../service/stagiaire.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-stagiaire-list',
  templateUrl: './stagiaire-list.component.html',
  styleUrls: ['./stagiaire-list.component.css']
})
export class StagiaireListComponent implements OnInit {
  objs: Array<Stagiaire> = [];
  cols: any[];

  constructor(private objService: StagiaireService, private datePipe: DatePipe, private confirmationService: ConfirmationService, private router: Router) {}

  ngOnInit() {
    this.getList();
    this.cols = [
      { field: 'id', header: '#' },
      { field: 'nom', header: 'nom' },
      { field: 'prenom', header: 'prenom' },
      { field: 'dateNaissance', header: 'dateNaissance' },
      { field: 'adresse', header: 'adresse' },
      { field: 'email', header: 'email' },
      { field: 'numTel', header: 'Tel' }
    ];
  }

  getList() {
    this.objService.list().subscribe(objsFromREST => {
      this.objs = objsFromREST;
    });
  }

  customSort(event: SortEvent) {
    event.data.sort((data1, data2) => {
      let value1 = data1[event.field];
      let value2 = data2[event.field];
      let result = null;

      if (value1 == null && value2 != null)
        result = -1;
      else if (value1 != null && value2 == null)
        result = 1;
      else if (value1 == null && value2 == null)
        result = 0;
      else if (typeof value1 === 'string' && typeof value2 === 'string')
        result = value1.localeCompare(value2);
      else
        result = (value1 < value2) ? -1 : (value1 > value2) ? 1 : 0;

      return (event.order * result);
    });
  }

  detailObj(obj: Stagiaire) {
    this.router.navigateByUrl('/stagiaire/' + obj.id);
  }

  deleteObj(obj: Stagiaire) {
    this.confirmationService.confirm({
      message: 'Do you want to delete this record?',
      header: 'Delete Confirmation',
      icon: 'fa fa-trash',
      accept: () => {
        this.objService.delete(obj.id).subscribe( value => {
          let index = -1;
          for (let i = 0; i < this.objs.length; i++) {
            if (this.objs[i].id === obj.id) {
              index = i;
              break;
            }
          }
          this.objs.splice(index, 1);
        });
      },
      reject: () => {
      }
    });
  }
}
