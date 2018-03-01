import { Component, OnInit } from '@angular/core';
import {Matiere} from '../../../model/matiere.model';

import {MatiereService} from '../../../service/matiere.service';
import {SortEvent} from 'primeng/api';
import {Formation} from '../../../model/formation.model';

@Component({
  selector: 'app-matiere-list',
  templateUrl: './matiere-list.component.html',
  styleUrls: ['./matiere-list.component.css']
})
export class MatiereListComponent implements OnInit {
formations: Array<Formation> =  [];
matieres: Array<Matiere> = [];
  cols: any[];
  value: number = 20;


  constructor(private matiereservice: MatiereService) {}

  ngOnInit() {
    this.getList();
    this.cols = [
      { field: 'id', header: '#' },
      { field: 'nom', header: 'Nom' },
      { field: 'couleur', header: 'Couleur' },
      { field: 'programmes', header: 'programmes' },
      { field: 'enseignements', header: 'enseignements' },
    ];
  }

  getList() {
    this.matiereservice.list().subscribe(matieresFromREST => {
      this.matieres=matieresFromREST;
    });
  }

  customSort(event: SortEvent) {
    event.data.sort((data1, data2) => {
      let value1 = data1[event.field];
      let value2 = data2[event.field];
      let result = null;

      if (value1 == null && value2 != null)
        result = -1;
      else if (value1 != null && value2 == null)
        result = 1;
      else if (value1 == null && value2 == null)
        result = 0;
      else if (typeof value1 === 'string' && typeof value2 === 'string')
        result = value1.localeCompare(value2);
      else
        result = (value1 < value2) ? -1 : (value1 > value2) ? 1 : 0;

      return (event.order * result);
    });
  }
}

