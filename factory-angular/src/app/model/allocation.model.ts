import {Stagiaire} from './stagiaire';
import {Ordinateur} from './ordinateur.model';
import {Formation} from './formation.model';

export class Allocation {

  public id: number;
<<<<<<< HEAD
  public version: number;
  public titre: string;
  public matieres: Array<Matiere> = [];
=======
  public formation: Formation;
  public stagiaire: Stagiaire;
  public ordinateur: Ordinateur;
>>>>>>> master

  constructor() {
  }
}
