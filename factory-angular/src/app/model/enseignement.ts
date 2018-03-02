import {Formateur} from './formateur';
import {Matiere} from './matiere.model';

export class Enseignement {

  public id: number;
  public niveau: string;
  public  formateur: Formateur;
  public matiere: Matiere;

  constructor() { }
}
