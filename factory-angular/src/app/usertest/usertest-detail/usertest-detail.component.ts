import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Globals} from '../../framework/globals';
import {UserTest} from '../../model/usertest.model';
import {UserTestService} from '../../service/usertest.service';

@Component({
  selector: 'app-usertest-detail',
  templateUrl: './usertest-detail.component.html',
  styleUrls: ['./usertest-detail.component.css']
})
export class UserTestDetailComponent implements OnInit {
  id: number;
  usertest: UserTest;

  constructor(public globals: Globals, private route: ActivatedRoute, private usertestService: UserTestService) {
    route.params.subscribe(param => {
      this.id = param['id'];
    });
  }

  ngOnInit() {
    this.usertestService.get(this.id).subscribe(usertestFromREST => {
      this.usertest = usertestFromREST;
    });
  }
}
