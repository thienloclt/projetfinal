import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Globals} from '../../../framework/globals';
import {FormationService} from '../../../service/formation.service';
import {FormBuilder} from '@angular/forms';
import {Stagiaire} from '../../../model/stagiaire';
import {StagiaireService} from '../../../service/stagiaire.service';
import {Formation} from '../../../model/formation.model';
import {Allocation} from '../../../model/allocation.model';
import {AllocationService} from '../../../service/allocation.service';

@Component({
  selector: 'app-formation-add-stagiaire',
  templateUrl: './formation-add-stagiaire.component.html',
  styleUrls: ['./formation-add-stagiaire.component.css']
})
export class FormationAddStagiaireComponent implements OnInit {

  @Input() id: number;
  @Output() eventemitter: EventEmitter<string> = new EventEmitter<string>();
  display: boolean = false;

  obj: Formation;
  sourceStagiaires: Stagiaire[] = [];
  targetStagiaires: Stagiaire[] = [];

  constructor(public globals: Globals, private fb: FormBuilder, private objService: FormationService, private stagiaireService: StagiaireService, private allocationService: AllocationService) {
  }

  ngOnInit() {
    this.objService.get(this.id).subscribe(objFromREST => {
      this.obj = objFromREST;
    });

    this.stagiaireService.getByOutOfFormation(this.id).subscribe(objsFromREST => {
      this.sourceStagiaires = objsFromREST;
    });

    this.stagiaireService.getByFormation(this.id).subscribe(objsFromREST => {
      this.targetStagiaires = objsFromREST;
    });
  }

  showDialog() {
    this.display = true;
  }

  onSubmit() {
    for(var item of this.targetStagiaires) {
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
