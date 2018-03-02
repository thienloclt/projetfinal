import {Programme} from './programme.model';
import {Enseignement} from './enseignement';

export class Formateur {

  public id: number;
  public nom: string;
  public prenom: string;
  public dateNaissance:string;
  public adresse:string;
  public numTel:string;
  public email:string;
  public competence: string;
  public enseignements:Set<Enseignement>;
  public programmes:Set<Programme>;

  constructor() { }
}
