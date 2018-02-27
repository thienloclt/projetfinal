import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Globals} from '../../framework/globals';
import {Cheval} from '../../model/cheval.model';
import {ChevalService} from '../../service/cheval.service';

@Component({
  selector: 'app-incident-list-child',
  templateUrl: './incident-list-child.component.html',
  styleUrls: ['./incident-list-child.component.css']
})
export class IncidentListChildComponent implements OnInit {
  @Input() cheval: Cheval;
  @Output() eventemitter: EventEmitter<string> = new EventEmitter<string>();

  constructor(public globals: Globals, private route: ActivatedRoute, private chevalService: ChevalService, private router: Router) {
  }

  ngOnInit() {
  }

  deleteCheval(): void {
    this.chevalService.delete(this.cheval.id).subscribe( value => {
      this.eventemitter.emit('Object deleted');
      this.router.navigateByUrl('/cheval');
    });
  }
}
