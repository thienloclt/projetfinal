import { Component, OnInit } from '@angular/core';
import {SortEvent} from 'primeng/api';
import {DatePipe} from '@angular/common';
import {Stagiaire} from '../../../model/stagiaire';
import {StagiaireService} from '../../../service/stagiaire.service';

@Component({
  selector: 'app-stagiaire-list',
  templateUrl: './stagiaire-list.component.html',
  styleUrls: ['./stagiaire-list.component.css']
})
export class StagiaireListComponent implements OnInit {
  objs: Array<Stagiaire> = [];
  cols: any[];
  value: number = 20;


  constructor(private objservice: StagiaireService, private datePipe: DatePipe) {}


  ngOnInit() {
    this.getList();
    this.cols = [
      { field: 'id', header: '#' },
      { field: 'titre', header: 'Titre' },
      { field: 'email', header: 'Email' },
      { field: 'level', header: 'level' },
      { field: 'type', header: 'Type' },
      { field: 'progress', header: 'Progress' },
      { field: 'dateCreation', header: 'Progress' },
      { field: 'dateModification', header: 'Progress' },
    ];
  }


  getList() {
    this.objservice.list().subscribe(objsFromREST => {
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
}

