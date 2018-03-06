import {Formation} from './formation.model';
import {Allocation} from './allocation.model';

export class Ordinateur {

  public id: number;
  public code: number;
  public nom: string;
  public coutJournalier: number;
  public processeur: string;
  public ram: string;
  public disqueDur: string;
  public anneeAchat: number;
  public allocations: Array<Allocation> = [];


  constructor() { }
}

