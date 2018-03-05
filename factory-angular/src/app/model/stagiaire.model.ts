import {Allocation} from './allocation.model';

export class Stagiaire {

  public id: number;
  public nom: string;
  public prenom: string;
  public dateNaissance:string;
  public adresse:string;
  public numTel:string;
  public email:string;
  public allocations: Array<Allocation> = [];



  constructor() { }
}

