import {Enseignement} from './enseignement.model';
import {Programme} from './programme.model';

export class Matiere {

  public id: number;
  public nom: string;
  public couleur: Couleur;
  public programmes: Array<Programme> = [];
  public enseignements: Array<Enseignement> = [];

  constructor() {
  }
}
export enum Couleur {
  ROUGE, NOIR, BLANC, BLEU,
}
