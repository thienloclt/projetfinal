import {Component, OnInit } from '@angular/core';
import {Salle} from '../../../model/salle.model';
import {SalleService} from '../../../service/salle.service';
import {Router} from '@angular/router';
import {DatePipe} from '@angular/common';

@Component({
  selector: 'app-salle-available-report',
  templateUrl: './salle-available-report.component.html',
  styleUrls: ['./salle-available-report.component.css']
})
export class SalleAvailableReportComponent implements OnInit {

  objs: Salle[];
  cols: any[];


  constructor(private objService: SalleService, private datePipe: DatePipe, private router: Router) {}

  ngOnInit() {
    this.getList();
    this.cols = [
      { field: 'id', header: '#' },
      { field: 'code', header: 'code' },
      { field: 'nom', header: 'nom' },
      { field:'capacite', header:'capacite' },
      { field: 'coutJournalier', header: 'coutJournalier' }
    ];
  }

  getList() {
    this.objService.list().subscribe(objsFromREST => {
      this.objs = objsFromREST;
    });
  }
}
