import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormationService} from '../../../service/formation.service';
import {Formation} from '../../../model/formation.model';
import {Globals} from '../../../framework/globals';
import {MatiereService} from '../../../service/matiere.service';
import {ProgrammeService} from '../../../service/programme.service';
import {Programme} from '../../../model/programme.model';
import {Matiere} from '../../../model/matiere.model';

@Component({
  selector: 'app-formation-add-matiere',
  templateUrl: './formation-add-matiere.component.html',
  styleUrls: ['./formation-add-matiere.component.css']
})

export class FormationAddMatiereComponent implements OnInit {
  @Input() id: number;
  @Output() eventemitter: EventEmitter<string> = new EventEmitter<string>();
  display: boolean = false;

  formation: Formation;

  sourceMatieres: Matiere[];
  targetMatieres: Matiere[];
  savedMatiere_IDs: number[];

  constructor(public globals: Globals, private formationService: FormationService, private matiereService: MatiereService, private programmeService: ProgrammeService) {
  }

  ngOnInit() {
  }

  loadData() {
    this.sourceMatieres = null;
    this.targetMatieres = [];
    this.savedMatiere_IDs = [];

    this.formationService.get(this.id).subscribe(objFromREST => {
      this.formation = objFromREST;

      this.programmeService.getByFormation(this.id).subscribe(objsFromREST => {
        this.formation.programmes = objsFromREST;

        for(var e of this.formation.programmes) {
          this.targetMatieres.push(e.matiere); //sorted by field "ORDRE" par SQL
          this.savedMatiere_IDs.push(e.matiere.id);
        }
      });
    });

    this.matiereService.getByOutOfFormation(this.id).subscribe(objsFromREST => {
      this.sourceMatieres = objsFromREST;
    });
  }

  showDialog() {
    this.loadData();
    this.display = true;
  }

  onSubmit() {
    let found: boolean = false;
    for (var itemsaved of this.savedMatiere_IDs) {
      for (var itemnew of this.targetMatieres) {
        if (itemsaved === itemnew.id) {
          found = true;
        }
      }
      if (!found) {
        for(var e of this.formation.programmes) {
          if (e.matiere.id === itemsaved) {
            console.log('delete: ' + e.matiere.nom);
            this.programmeService.delete(e.id).subscribe();
          }
        }
      }
      found = false;
    }

    let ordre = 1;
    for (var itemnew of this.targetMatieres) {
      for (var itemsaved of this.savedMatiere_IDs) {
        if (itemnew.id === itemsaved) {
          found = true;
        }
      }
      if(!found) {
        let programme = new Programme();
        programme.matiere = itemnew;
        programme.formation = this.formation;
        programme.ordre = ordre;
        console.log('add: ' + itemnew.nom);
        this.programmeService.add(programme).subscribe();
      }
      else {
        for(var e of this.formation.programmes) {
          if (e.matiere.id === itemnew.id) {
            console.log('update: ' + e.matiere.nom);
            let programme = new Programme();
            programme = e;
            programme.ordre = ordre;
            this.programmeService.update(programme).subscribe();
          }
        }
      }

      ordre++;
      found = false;
    }

    this.eventemitter.emit('tranfere');
    this.display = false;
  }

  onCancel() {
    this.display = false;
  }
}
