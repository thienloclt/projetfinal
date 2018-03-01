<<<<<<< HEAD
import {Formation} from './formation.model';
=======
import {Enseignement} from './enseignement';
>>>>>>> solange

export class Matiere {

  public id: number;
<<<<<<< HEAD
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
=======
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
>>>>>>> solange



