import {Enseignement} from './enseignement';

export class Matiere {

  public id: number;
  public nom: string;
  public version: number;
  public couleur: Couleur;
  // public programmes: Set<Programme>;
  public enseignements: Set<Enseignement>;



  constructor() { }
}
 export enum Couleur {
     ROUGE, NOIR, BLANC, BLEU,
   }



