import {Formation} from './formation.model';

export class Projecteur {

  public id: number;
  public code: number;
  public nom: string;
  public coutJournalier: number;
  public formations:Set<Formation>;


  constructor() { }
}

