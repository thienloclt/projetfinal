import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {Matiere} from '../../../model/matiere.model';
import {FormationService} from '../../../service/formation.service';
import {MatiereService} from '../../../service/matiere.service';
import {Globals} from '../../../framework/globals';
import {Programme} from '../../../model/programme.model';
import {Formation} from '../../../model/formation.model';
import {ProgrammeService} from '../../../service/programme.service';

@Component({
  selector: 'app-formation-add-programme',
  templateUrl: './formation-add-programme.component.html',
  styleUrls: ['./formation-add-programme.component.css']
})
export class FormationAddProgrammeComponent implements OnInit {
  @Input() id: number;
  @Output() eventemitter: EventEmitter<string> = new EventEmitter<string>();
  display: boolean = false;

  obj: Formation;
  sourceMatieres: Matiere[] = [];
  targetMatieres: Matiere[] = [];

  constructor(public globals: Globals, private fb: FormBuilder, private objService: FormationService, private matiereService: MatiereService, private programmeService: ProgrammeService) {
  }

  ngOnInit() {
    this.objService.get(this.id).subscribe(objFromREST => {
      this.obj = objFromREST;
    });

    this.matiereService.getByOutOfFormation(this.id).subscribe(objsFromREST => {
      this.sourceMatieres = objsFromREST;
    });

    this.matiereService.getByFormation(this.id).subscribe(objsFromREST => {
      this.targetMatieres = objsFromREST;
    });
  }

  showDialog() {
    this.display = true;
  }

  onSubmit() {
    let i = 1;
    for(var item of this.targetMatieres) {
      let programme = new Programme();
      programme.matiere = item;
      programme.formation = this.obj;
      programme.ordre = i++;
      this.programmeService.add(programme).subscribe();
    }
    this.eventemitter.emit('tranfere');
    this.display = false;
  }

  onCancel() {
    this.display = false;
  }
}
