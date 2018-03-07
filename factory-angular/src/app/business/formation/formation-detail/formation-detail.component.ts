import {Component, OnInit, ViewChild} from '@angular/core';
import {Globals} from '../../../framework/globals';
import {ActivatedRoute, Router} from '@angular/router';
import {FormationService} from '../../../service/formation.service';
import {Formation} from '../../../model/formation.model';
import {ConfirmationService} from 'primeng/api';
import {ProgrammeService} from '../../../service/programme.service';
import {OrdinateurService} from '../../../service/ordinateur.service';
import {ISubscription} from 'rxjs/Subscription';
import {ProgressBar} from 'primeng/primeng';
import {ProgressBarComponent} from '../../../framework/progress-bar/progress-bar.component';

@Component({
  selector: 'app-formation-detail',
  templateUrl: './formation-detail.component.html',
  styleUrls: ['./formation-detail.component.css']
})

export class FormationDetailComponent implements OnInit {
  id: number;
  formation: Formation = null;
  private subscription: ISubscription;

  @ViewChild(ProgressBarComponent) progrssBar: ProgressBarComponent;

  constructor(public globals: Globals, private route: ActivatedRoute, private router: Router, private formationService: FormationService, private ordinateurService: OrdinateurService, private programmeService: ProgrammeService, private confirmationService: ConfirmationService) {
  }

  ngOnInit() {
    this.route.params.subscribe(param => {
      this.id = param['id'];
      this.getObj();
    });
  }

  deleteObj() {
    this.confirmationService.confirm({
      message: 'Do you want to delete this record?',
      header: 'Delete Confirmation',
      icon: 'fa fa-trash',
      accept: () => {
        this.formationService.delete(this.id).subscribe( value => {
          this.router.navigateByUrl('/formation');
        });
      },
      reject: () => {
      }
    });
  }

  getObj() {
    this.formation = new Formation();
    this.formationService.get(this.id).subscribe(objFromREST => {
      this.formation = objFromREST;
      this.programmeService.getByFormation(this.id).subscribe(objsFromREST => {
        this.formation.programmes = objsFromREST;
      });
    });
  }

  getFromChild(event) {
    this.progrssBar.showDialog();
  }

  getFromChildProgressBar(event) {
    this.getObj();
  }
}
