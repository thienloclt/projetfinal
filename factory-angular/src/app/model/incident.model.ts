export class Incident {

  public id: number;
  public titre: string;
  public email: string;
  public level: string;
  public type: string;
  public progress: number;
  public dateCreation: string;
  public dateModification: string;
  public open: boolean;
  public description: string;

  constructor() { }
}

export enum LevelIncident {
  FATAL = 'Fatal',
  ERROR = 'Error',
  MEDIUM = 'Medium',
  MINOR = 'Minor'
}

export enum TypeIncident {
  BUG = 'Bug',
  FEATURE = 'Feature'
}
