import {Component, OnInit, ViewChild} from '@angular/core';
import {ConfirmationService, SortEvent} from 'primeng/api';
import {DatePipe} from '@angular/common';
import {Formation} from '../../../model/formation.model';
import {FormationService} from '../../../service/formation.service';
import {Router} from '@angular/router';
import {FormationAddComponent} from '../formation-add/formation-add.component';
import {ProgressBarComponent} from '../../../framework/progress-bar/progress-bar.component';

@Component({
  selector: 'app-formation-list',
  templateUrl: './formation-list.component.html',
  styleUrls: ['./formation-list.component.css']
})
export class FormationListComponent implements OnInit {

  @ViewChild(ProgressBarComponent) progrssBar: ProgressBarComponent;
  @ViewChild(FormationAddComponent) formationAddComponent: FormationAddComponent;

  objs: Array<Formation> = [];
  cols: any[];

  constructor(private objService: FormationService, private datePipe: DatePipe, private confirmationService: ConfirmationService, private router: Router) {}

  ngOnInit() {
    this.getList();
    this.cols = [
      { field: 'id', header: '#' },
      { field: 'titre', header: 'Titre' },
      { field: 'dateDebut', header: 'Debut' },
      { field: 'dateFin', header: 'Fin' }
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

  detailObj(obj: Formation) {
    this.router.navigateByUrl('/formation/' + obj.id);
  }

  addObj() {
    this.formationAddComponent.showDialog();
  }

  deleteObj(obj: Formation) {
    this.confirmationService.confirm({
      message: 'Voulez-vous vraiment supprimer?',
      header: 'Confirmation',
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

  getFromChild(event) {
    this.progrssBar.showDialog();
  }

  getFromChildProgressBar(event) {
    this.getList();
  }
}
