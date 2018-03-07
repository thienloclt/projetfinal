import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Globals} from '../../../framework/globals';
import {FormBuilder, FormGroup} from '@angular/forms';
import {FormationService} from '../../../service/formation.service';
import {Projecteur} from '../../../model/projecteur.model';
import {Salle} from '../../../model/salle.model';
import {ProjecteurService} from '../../../service/projecteur.service';
import {SalleService} from '../../../service/salle.service';
import {Formation} from '../../../model/formation.model';

@Component({
  selector: 'app-formation-add-materiel',
  templateUrl: './formation-add-materiel.component.html',
  styleUrls: ['./formation-add-materiel.component.css']
})

export class FormationAddMaterielComponent implements OnInit {

  @Input() id: number;
  @Output() eventemitter: EventEmitter<string> = new EventEmitter<string>();

  display: boolean = false;

  myForm: FormGroup;
  formsubmitted: boolean = false;

  formation: Formation;

  salles: Salle[];
  selectedSalle: Salle;
  projecteurs: Projecteur[];
  selectedProjecteur: Projecteur;

  constructor(public globals: Globals, private fb: FormBuilder, private formationService: FormationService, private salleService: SalleService, private projecteurService: ProjecteurService) {
    this.myForm = this.fb.group({
      'salle': [null],
      'projecteur': [null]
    });
  }

  ngOnInit() {
  }

  loadData() {
    this.salles = null;
    this.projecteurs = null;

    this.formationService.get(this.id).subscribe(objFromREST => {
      this.formation = objFromREST;
      this.myForm.controls['salle'].setValue(this.formation.salle);
      this.myForm.controls['projecteur'].setValue(this.formation.projecteur);
    });

    this.salleService.list().subscribe(objsFromREST => {
      this.salles = objsFromREST;
    });

    this.projecteurService.list().subscribe(objsFromREST => {
      this.projecteurs = objsFromREST;
    });
  }

  showDialog() {
    this.loadData();
    this.display = true;
  }

  onSubmit() {
    this.formation.salle = this.myForm.controls['salle'].value;
    this.formation.projecteur = this.myForm.controls['projecteur'].value;

    this.formationService.update(this.formation).subscribe(val => {
      this.eventemitter.emit('tranfere');
      this.display = false;
    });
  }

  onCancel() {
    this.display = false;
  }

  equalsSalle(o1: Salle, o2: Salle) {
    if (o1 == null || o2 == null)
      return false;
    return o1.id === o2.id;
  }

  equalsProjecteur(o1: Projecteur, o2: Projecteur) {
    if (o1 == null || o2 == null)
      return false;
    return o1.id === o2.id;
  }
}
