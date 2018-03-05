import {Matiere} from './matiere.model';
import {Formation} from './formation.model';
import {Formateur} from './formateur.model';


export class Programme {

  public id: number;

  public version: number;
  public titre: string;
  public matieres: Array<Matiere> = [];
  public matiere: Matiere;
  public ordre: number;
  public formation: Formation;

  public formateur: Formateur;


  constructor() { }
}
