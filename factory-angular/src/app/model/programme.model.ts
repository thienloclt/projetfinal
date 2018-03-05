import {Matiere} from './matiere.model';
import {Formation} from './formation.model';
import {Formateur} from './formateur';

export class Programme {

  public id: number;
  public ordre: number;
  public formation: Formation;
  public matiere: Matiere;
  public formateur: Formateur;

  constructor() { }
}
