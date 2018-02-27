import {Component, OnInit} from '@angular/core';
import {UserTestService} from '../../service/usertest.service';
import {UserTest} from '../../model/usertest.model';

@Component({
  selector: 'app-usertest-list',
  templateUrl: './usertest-list.component.html',
  styleUrls: ['./usertest-list.component.css']
})
export class UserTestListComponent implements OnInit {
  usertests: Array<UserTest> = [];
  constructor(private usertestService: UserTestService) {}

  ngOnInit() {
    this.getList();
  }
  getFromChild(event) {
    this.getList();
  }
  getList() {
    this.usertestService.list().subscribe(usertestsFromREST => {this.usertests = usertestsFromREST;
    });
  }
}
