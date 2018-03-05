import {Stagiaire} from './stagiaire';
import {Ordinateur} from './ordinateur.model';
import {Formation} from './formation.model';

export class Allocation {

  public id: number;
  public formation: Formation;
  public stagiaire: Stagiaire;
  public ordinateur: Ordinateur;

  constructor() {
  }
}
