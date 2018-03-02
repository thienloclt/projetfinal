import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Globals} from '../../../framework/globals';
import {Form, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {FormationService} from '../../../service/formation.service';
import {Projecteur} from '../../../model/projecteur.model';
import {Salle} from '../../../model/salle.model';
import {ProjecteurService} from '../../../service/projecteur.service';
import {SalleService} from '../../../service/salle.service';
import {Formation} from '../../../model/formation.model';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-formation-add-child',
  templateUrl: './formation-add-child.component.html',
  styleUrls: ['./formation-add-child.component.css']
})
export class FormationAddChildComponent implements OnInit {

  @Input() id: number;
  @Output() eventemitter: EventEmitter<string> = new EventEmitter<string>();

  display: boolean = false;

  myForm: FormGroup;
  formsubmitted: boolean = false;
  obj: Formation;

  salles: Array<Salle> = [];
  projecteurs: Array<Projecteur> = [];
  selectedSalle: Salle;
  selectedProjecteur: Projecteur;

  constructor(public globals: Globals, private fb: FormBuilder, private objService: FormationService, private salleService: SalleService, private projecteurService: ProjecteurService) {
    this.myForm = this.fb.group({
      'version': [''],
      'salle': [''],
      'projecteur': ['']
    });
  }

  ngOnInit() {
    this.objService.get(this.id).subscribe(objFromREST => {
      this.obj = objFromREST;
      this.myForm.controls['version'].setValue(this.obj.version);
      this.myForm.controls['salle'].setValue(this.obj.salle);
      this.myForm.controls['projecteur'].setValue(this.obj.projecteur);
    });

    this.salleService.list().subscribe(objsFromREST => {
      this.salles = objsFromREST;
    });
    this.projecteurService.list().subscribe(objsFromREST => {
      this.projecteurs = objsFromREST;
    });
/*    if (this.id) {
      this.objService.get(this.id).subscribe(objFromREST => {
        this.myForm.controls['id'].setValue(objFromREST.id);
        this.myForm.controls['salle'].setValue(objFromREST.salle);
        this.myForm.controls['projecteur'].setValue(objFromREST.projecteur);
      });
    }*/
  }

  showDialog() {
    this.display = true;
  }

  onSubmit() {
    this.formsubmitted = true;
    console.log(this.myForm.value);
    this.objService.get(this.id).subscribe(objFromREST => {
      this.obj = objFromREST;
      console.log(this.obj);
      this.obj.salle = this.myForm.controls['salle'].value;
      this.obj.projecteur = this.myForm.controls['projecteur'].value;
      console.log(this.obj);
      this.objService.update(this.obj).subscribe(val => {
        this.display = false;
        this.eventemitter.emit('Object deleted');
      });

    });

/*    if (this.myForm.valid) {
      let obj: Formation;
      obj = this.myForm.value;

      console.log(obj);
      if (this.id) {
      } else {

      }
    }*/

  }

  CancelDialog() {
    console.log('cancel');
    this.display = false;
  }
}
