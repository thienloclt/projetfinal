import {Matiere} from './matiere.model';
import {Formation} from './formation.model';
import {Formateur} from './formateur';

export class Programme {

  public id: number;
<<<<<<< HEAD
  public version: number;
  public titre: string;
  public matieres: Array<Matiere> = [];
=======
  public ordre: number;
  public formation: Formation;
  public matiere: Matiere;
  public formateur: Formateur;
>>>>>>> master

  constructor() { }
}
