import {Salle} from './salle.model';
import {Projecteur} from './projecteur.model';
import {Gestionnaire} from './gestionnaire.model';
import {Programme} from './programme.model';
import {Allocation} from './allocation.model';

export class Formation {

  public id: number;
  public version: number;
  public titre: string;
  public dateDebut: string;
  public dateFin: string;
  public salle = new Salle();
  public projecteur = new Projecteur();
  public gestionnaire = new Gestionnaire();
  public programmes: Array<Programme> = [];
  public allocations: Array<Allocation> = [];

  constructor() { }
}
