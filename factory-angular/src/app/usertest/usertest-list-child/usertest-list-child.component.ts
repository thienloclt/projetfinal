import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Globals} from '../../framework/globals';
import {UserTest} from '../../model/usertest.model';
import {UserTestService} from '../../service/usertest.service';

@Component({
  selector: 'app-usertest-list-child',
  templateUrl: './usertest-list-child.component.html',
  styleUrls: ['./usertest-list-child.component.css']
})
export class UserTestListChildComponent implements OnInit {
  @Input() usertest: UserTest;
  @Output() eventemitter: EventEmitter<string> = new EventEmitter<string>();

  constructor(public globals: Globals, private route: ActivatedRoute, private usertestService: UserTestService, private router: Router) {
  }

  ngOnInit() {
  }

  deleteUserTest(): void {
    this.usertestService.delete(this.usertest.id).subscribe( value => {
      this.eventemitter.emit('Object deleted');
      this.router.navigateByUrl('/usertest');
    });
  }
}
