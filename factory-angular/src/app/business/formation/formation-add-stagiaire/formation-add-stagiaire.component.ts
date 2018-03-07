import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Globals} from '../../../framework/globals';
import {FormationService} from '../../../service/formation.service';
import {Stagiaire} from '../../../model/stagiaire.model';
import {StagiaireService} from '../../../service/stagiaire.service';
import {Formation} from '../../../model/formation.model';

@Component({
  selector: 'app-formation-add-stagiaire',
  templateUrl: './formation-add-stagiaire.component.html',
  styleUrls: ['./formation-add-stagiaire.component.css']
})
export class FormationAddStagiaireComponent implements OnInit {

  @Input() id: number;
  @Output() eventemitter: EventEmitter<string> = new EventEmitter<string>();
  display: boolean = false;

  formation: Formation;
  sourceStagiaires: Stagiaire[];
  targetStagiaires: Stagiaire[];

  constructor(public globals: Globals, private formationService: FormationService, private stagiaireService: StagiaireService) {
  }

  ngOnInit() {
  }

  loadData() {
    this.sourceStagiaires = [];
    this.targetStagiaires = [];

    this.formationService.get(this.id).subscribe(objFromREST => {
      this.formation = objFromREST;
      this.targetStagiaires = this.formation.stagiaires;
    });

    this.stagiaireService.getByOutOfFormation(this.id).subscribe(objsFromREST => {
      this.sourceStagiaires = objsFromREST;
    });
  }

  showDialog() {
    this.loadData();
    this.display = true;
  }

  onSubmit() {
    this.formation.stagiaires = this.targetStagiaires;
    this.formationService.update(this.formation).subscribe();
    this.eventemitter.emit('tranfere');
    this.display = false;
  }

  onCancel() {
    this.display = false;
  }
}
