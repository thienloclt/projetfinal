import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Stagiaire} from '../../../model/stagiaire.model';
import {Globals} from '../../../framework/globals';
import {FormationService} from '../../../service/formation.service';
import {Allocation} from '../../../model/allocation.model';
import {FormBuilder} from '@angular/forms';
import {AllocationService} from '../../../service/allocation.service';
import {StagiaireService} from '../../../service/stagiaire.service';
import {Formation} from '../../../model/formation.model';
import {Ordinateur} from '../../../model/ordinateur.model';
import {OrdinateurService} from '../../../service/ordinateur.service';

@Component({
  selector: 'app-formation-add-ordinateur',
  templateUrl: './formation-add-ordinateur.component.html',
  styleUrls: ['./formation-add-ordinateur.component.css']
})
export class FormationAddOrdinateurComponent implements OnInit {

  @Input() id: number;
  @Output() eventemitter: EventEmitter<string> = new EventEmitter<string>();
  display: boolean = false;

  obj: Formation;
  sourceOrdinateurs: Ordinateur[] = [];
  targetOrdinateurs: Ordinateur[] = [];

  constructor(public globals: Globals, private fb: FormBuilder, private objService: FormationService, private ordinateurService: OrdinateurService) {
  }

  ngOnInit() {
  }

  loadData() {
    this.objService.get(this.id).subscribe(objFromREST => {
      this.obj = objFromREST;
    });

    this.ordinateurService.getByOutOfFormation(this.id).subscribe(objsFromREST => {
      this.sourceStagiaires = objsFromREST;
    });
  }

  showDialog() {
    this.loadData();
    this.display = true;
  }

  onSubmit() {
    for (var item of this.targetStagiaires) {
      let allocation: Allocation = new Allocation();
      allocation.stagiaire = item;
      allocation.formation = this.obj;
      this.allocationService.add(allocation).subscribe();
    }
    this.eventemitter.emit('tranfere');
    this.display = false;
  }

  onCancel() {
    this.display = false;
  }
}
