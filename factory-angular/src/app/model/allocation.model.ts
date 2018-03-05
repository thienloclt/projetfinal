
import {Ordinateur} from './ordinateur.model';
import {Formation} from './formation.model';
import {Matiere} from './matiere.model';
import {Stagiaire} from './stagiaire.model';

export class Allocation {

  public id: number;

  public version: number;
  public titre: string;
  public matieres: Array<Matiere> = [];

  public formation: Formation;
  public stagiaire: Stagiaire;
  public ordinateur: Ordinateur;


  constructor() {
  }
}
