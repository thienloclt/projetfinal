import {Matiere} from './matiere.model';

export class Formation {

  public id: number;
  public version: number;
  public titre: string;
  public matieres:Set<Matiere>;

  constructor() { }
}
