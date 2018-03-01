import {Formation} from './formation.model';

export class Matiere {

  public id: number;
  public version: number;
  public nom: string;
  public couleur: Couleur;
  public programmes: Set<Programme>;
  public enseignements: Set<Enseignement>;


  constructor() { }
}
export enum Couleur {
  ROUGE, NOIR, BLANC, BLEU,
}



