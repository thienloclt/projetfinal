import {Matiere} from './matiere.model';
import {Formation} from './formation.model';
import {Formateur} from './formateur.model';

export class Programme {

  public id: number;
  public titre: string;
  public ordre: number;
  public matiere: Matiere;
  public formation: Formation;
  public formateur: Formateur;

  constructor() { }
}
