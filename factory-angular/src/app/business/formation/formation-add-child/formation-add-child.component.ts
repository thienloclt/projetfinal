import {Component, Input, OnInit} from '@angular/core';
import {Globals} from '../../../framework/globals';
import {Form, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {FormationService} from '../../../service/formation.service';
import {Projecteur} from '../../../model/projecteur.model';
import {Salle} from '../../../model/salle.model';
import {ProjecteurService} from '../../../service/projecteur.service';
import {SalleService} from '../../../service/salle.service';

@Component({
  selector: 'app-formation-add-child',
  templateUrl: './formation-add-child.component.html',
  styleUrls: ['./formation-add-child.component.css']
})
export class FormationAddChildComponent implements OnInit {

  @Input() id: number;
  display: boolean = false;

  myForm: FormGroup;
  formsubmitted: boolean = false;
  salles: Array<Salle> = [];
  projecteurs: Array<Projecteur> = [];
  selectedSalle: Salle;

  constructor(public globals: Globals, private fb: FormBuilder, private objService: FormationService, private salleService: SalleService, private projecteurService: ProjecteurService) {
    this.salleService.list().subscribe(objFromREST => {
      this.salles = objFromREST;
      console.log(this.salles);
    });
    this.projecteurService.list().subscribe(objFromREST => {
      this.projecteurs = objFromREST;
    });

    this.myForm = this.fb.group({
      'id': [''],
      'salle': [''],
      'projecteur': ['']
    });
  }

  ngOnInit() {
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

  OKDialog() {
    console.log('OK');
    this.display = false;
  }

  CancelDialog() {
    console.log('cancel');
    this.display = false;
  }
}
