import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Globals} from '../../framework/globals';
import {ChevalService} from '../../service/cheval.service';
import {Cheval} from '../../model/cheval.model';

@Component({
  selector: 'app-cheval-detail',
  templateUrl: './cheval-detail.component.html',
  styleUrls: ['./cheval-detail.component.css']
})
export class ChevalDetailComponent implements OnInit {
  id: number;
  cheval: Cheval;

  constructor(public globals: Globals, private route: ActivatedRoute, private chevalService: ChevalService) {
    route.params.subscribe(param => {
      this.id = param['id'];
    });
  }

  ngOnInit() {
    this.chevalService.get(this.id).subscribe(chevalFromREST => {
      this.cheval = chevalFromREST;
    });
  }
}
