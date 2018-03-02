import {Formation} from './formation.model';

export class Ordinateur {

  public id: number;
  public code: number;
  public nom: string;
  public coutJournalier: number;
  public processeur: string;
  public ram: string;
  public disqueDur: string;
  public anneeAchat: number;
  public formations: Set<Formation>;


  constructor() { }
}

