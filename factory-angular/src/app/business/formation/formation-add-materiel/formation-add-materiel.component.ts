import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Globals} from '../../../framework/globals';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
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
  obj: Formation;

  salles: Array<Salle> = [];
  projecteurs: Array<Projecteur> = [];

  constructor(public globals: Globals, private fb: FormBuilder, private objService: FormationService, private salleService: SalleService, private projecteurService: ProjecteurService) {
    this.myForm = this.fb.group({
      'salle': [null],
      'projecteur': [null]
    });
  }

  ngOnInit() {
    this.objService.get(this.id).subscribe(objFromREST => {
      this.obj = objFromREST;
      this.myForm.controls['salle'].setValue(this.obj.salle);
      this.myForm.controls['projecteur'].setValue(this.obj.projecteur);
    });

    this.salleService.list().subscribe(objsFromREST => {
      this.salles = objsFromREST;
    });

    this.projecteurService.list().subscribe(objsFromREST => {
      this.projecteurs = objsFromREST;
    });
  }

  showDialog() {
    this.display = true;
  }

  onSubmit() {
    this.obj.salle = this.myForm.controls['salle'].value;
    this.obj.projecteur = this.myForm.controls['projecteur'].value;

    this.objService.update(this.obj).subscribe(val => {
      this.eventemitter.emit('tranfere');
      this.display = false;
    });
  }

  onCancel() {
    console.log('cancel');
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
