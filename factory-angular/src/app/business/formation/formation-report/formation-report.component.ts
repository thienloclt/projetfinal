import {Component, OnInit} from '@angular/core';
import {FormationService} from '../../../service/formation.service';
import {Formation} from '../../../model/formation.model';
import {Globals} from '../../../framework/globals';
import {ProgrammeService} from '../../../service/programme.service';
import {ActivatedRoute} from '@angular/router';
import 'fullcalendar';

@Component({
  selector: 'app-formation-report',
  templateUrl: './formation-report.component.html',
  styleUrls: ['./formation-report.component.css']
})

export class FormationReportComponent implements OnInit {

  id: number;

  display: boolean = false;

  formation: Formation;
  sDateView: string;
  startDate: Date;
  events: MyEvent[];

  header = {
    left: 'prev,next',
    center: 'title',
    right: ',,'
  };

  constructor(public globals: Globals, private route: ActivatedRoute, private formationService: FormationService, private programmeService: ProgrammeService) {
    this.route.params.subscribe(param => {
      this.id = param['id'];
      this.sDateView = param['datedebut'];
      this.formationService.get(this.id).subscribe(objFromREST => {
        this.formation = objFromREST;
        this.startDate = new Date(this.formation.dateDebut);
        this.sDateView = this.startDate.toLocaleDateString();
        this.loadData();
      });
    });
  }

  ngOnInit() {
  }

  loadData() {
    this.events = [];
    let startDate = this.startDate;
    let endDate = this.startDate;

    this.programmeService.getByFormation(this.id).subscribe(objsFromREST => {
      this.formation.programmes = objsFromREST;
      for (var e of this.formation.programmes) {
        let myEvent = new MyEvent();
        myEvent.title = e.matiere.nom;
        myEvent.start = startDate.toLocaleDateString();
        for (var i = 0; i < e.matiere.duree; i ++) {
          endDate.setDate(endDate.getDate() + 1);
          if (endDate.getDay() === 6)
            endDate.setDate(endDate.getDate() + 2);
          if (endDate.getDay() === 0)
            endDate.setDate(endDate.getDate() + 1);
        }
        myEvent.end = endDate.toLocaleDateString();
        this.events.push(myEvent);

        startDate = endDate;
      }
    });
  }

  showDialog() {
    this.loadData();
    this.display = true;
  }
}

export class MyEvent {
  id: number;
  title: string;
  start: string;
  end: string;
  allDay: boolean = true;
}
