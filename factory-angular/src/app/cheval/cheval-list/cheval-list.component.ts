import {Component, OnChanges, OnInit} from '@angular/core';
import {Cheval} from '../../model/cheval.model';
import {ChevalService} from '../../service/cheval.service';
import {CentreEquestreService} from '../../service/centreequestre.service';

@Component({
  selector: 'app-cheval-list',
  templateUrl: './cheval-list.component.html',
  styleUrls: ['./cheval-list.component.css']
})
export class ChevalListComponent implements OnInit, OnChanges {
  chevals: Array<Cheval> = [];

  constructor(private chevalService: ChevalService, private centreequestreService: CentreEquestreService) {}

  ngOnInit() {
    this.getList();
  }
  ngOnChanges() {
    console.log('fdsfgsdgsg');
  }
  getFromChild(event) {
    this.getList();
  }
  getList() {
    this.chevalService.list().subscribe(chevalsFromREST => {
      this.chevals = chevalsFromREST;
    });
  }
}
