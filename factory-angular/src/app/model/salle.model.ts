import {Formation} from './formation.model';

export class Salle {

  public id: number;
  public code: number;
  public nom: string;
  public  capacite :number;
  public coutJournalier : number;
  public formations: Array<Formation> = [];

  constructor() {
  }
}
