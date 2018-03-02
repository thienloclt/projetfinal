
import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Message} from 'primeng/api';
import {Incident, LevelIncident, TypeIncident} from '../../../model/incident.model';
import {Globals} from '../../../framework/globals';
import {IncidentService} from '../../../service/incident.service';

@Component({
  selector: 'app-incident-add',
  templateUrl: './incident-add.component.html',
  styleUrls: ['./incident-add.component.css']
})
export class IncidentAddComponent implements OnInit {
  id: number;
  myForm: FormGroup;
  formsubmitted = false;

  incidents: Array<Incident> = [];
  typeIncident = TypeIncident;
  typeIncidents: any[];
  levelIncident = LevelIncident;
  levelIncidents: any[];

  val1 = 0;
  msgs: Message[];

  constructor(public globals: Globals, private fb: FormBuilder, private route: ActivatedRoute, private router: Router,
              private incidentService: IncidentService) {

    this.route.params.subscribe(param => {
      this.id = param['id'];
    });

    this.myForm = this.fb.group({
      'id': [''],
      'titre': ['', Validators.compose([Validators.required, Validators.minLength(3)])],
      'email': ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.email])],
      'level': ['', Validators.compose([Validators.required])],
      'type': ['', Validators.compose([Validators.required])],
      'progress': ['']
    });

    this.levelIncidents = Object.keys(this.levelIncident).filter(String);
    this.typeIncidents = Object.keys(this.typeIncident).filter(String);
  }

  ngOnInit() {
    if (this.id) {
    }
  }

  onSubmit() {
    this.formsubmitted = true;

    if (this.myForm.valid) {
      let incident: Incident;
      incident  = this.myForm.value;



      if (this.id) {
      } else {
        this.incidentService.add(incident).subscribe(val => {
          this.msgs = [];
          this.msgs.push({ severity: 'info', summary: 'Car Deleted', detail: 'Saved!!!' });
          this.router.navigateByUrl('/incident');
        });
      }
    }
  }
}
