import { Component, OnInit } from '@angular/core';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';

const now = new Date();

@Component({
  selector: 'app-testbootstrap',
  templateUrl: './testbootstrap.component.html',
  styleUrls: ['./testbootstrap.component.css']
})
export class TestbootstrapComponent implements OnInit {
  model: NgbDateStruct;
  date: {year: number, month: number};

  selectToday() {
    this.model = {year: now.getFullYear(), month: now.getMonth() + 1, day: now.getDate()};
  }
  ngOnInit() {
  }
}
