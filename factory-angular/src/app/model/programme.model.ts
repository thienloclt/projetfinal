import {Matiere} from './matiere.model';

export class Programme {

  public id: number;
  public version: number;
  public titre: string;
  public matieres:Set<Matiere>;

  constructor() { }
}
