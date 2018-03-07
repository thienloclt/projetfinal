import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {Globals} from '../../../framework/globals';
import {FormationService} from '../../../service/formation.service';
import {Formation} from '../../../model/formation.model';
import {Ordinateur} from '../../../model/ordinateur.model';
import {OrdinateurService} from '../../../service/ordinateur.service';
import {ProgressBarComponent} from '../../../framework/progress-bar/progress-bar.component';

@Component({
  selector: 'app-formation-add-ordinateur',
  templateUrl: './formation-add-ordinateur.component.html',
  styleUrls: ['./formation-add-ordinateur.component.css']
})
export class FormationAddOrdinateurComponent implements OnInit {

  @Input() id: number;
  @Output() eventemitter: EventEmitter<string> = new EventEmitter<string>();

  display: boolean = false;

  formation: Formation;
  sourceOrdinateurs: Ordinateur[];
  targetOrdinateurs: Ordinateur[];

  constructor(public globals: Globals, private formationService: FormationService, private ordinateurService: OrdinateurService) {
  }

  ngOnInit() {
  }

  loadData() {
    this.sourceOrdinateurs = [];
    this.targetOrdinateurs = [];

    this.formationService.get(this.id).subscribe(objFromREST => {
      this.formation = objFromREST;
      this.targetOrdinateurs = this.formation.ordinateurs;
    });

    this.ordinateurService.getByOutOfFormation(this.id).subscribe(objsFromREST => {
      this.sourceOrdinateurs = objsFromREST;
    });
  }

  showDialog() {
    this.loadData();
    this.display = true;
  }

  onSubmit() {
    this.formation.ordinateurs = this.targetOrdinateurs;
    this.formationService.update(this.formation).subscribe();
    this.eventemitter.emit('tranfere');
    this.display = false;
  }

  onCancel() {
    this.display = false;
  }
}
