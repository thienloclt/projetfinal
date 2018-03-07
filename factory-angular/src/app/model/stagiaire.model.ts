import {Formation} from './formation.model';

export class Stagiaire {

  public id: number;
  public nom: string;
  public prenom: string;
  public dateNaissance:string;
  public adresse:string;
  public numTel:string;
  public email:string;

  public formations: Formation[];

  constructor() { }
}

