import {Programme} from './programme.model';
import {Enseignement} from './enseignement.model';

export class Formateur {

  public id: number;
  public nom: string;
  public prenom: string;
  public dateNaissance:string;
  public adresse:string;
  public numTel:string;
  public email:string;
  public competence: string;
  public titre: string;
  public enseignements: Array<Enseignement> = [];
  public programmes: Array<Programme> = [];

  constructor() { }

  }


