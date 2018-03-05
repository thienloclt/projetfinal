import {Allocation} from './allocation.model';

export class Stagiaire {

  public id: number;
  public nom: string;
  public prenom: string;
<<<<<<< HEAD:factory-angular/src/app/model/stagiaire.model.ts
  public dateNaissance:string;
  public adresse:string;
  public numTel:string;
  public email:string;
  public allocations: Array<Allocation> = [];

=======
  public dateNaissance: string;
  public adresse: string;
  public numTel: string;
  public email: string;
>>>>>>> master:factory-angular/src/app/model/stagiaire.ts

  constructor() { }
}

