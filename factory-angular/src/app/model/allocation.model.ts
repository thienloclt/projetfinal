import {Matiere} from './matiere.model';

export class Allocation {

  public id: number;
  public version: number;
  public titre: string;
  public matieres:Set<Matiere>;

  constructor() { }
}
