import {Salle} from './salle.model';
import {Projecteur} from './projecteur.model';
import {Gestionnaire} from './gestionnaire.model';
import {Programme} from './programme.model';
import {Ordinateur} from './ordinateur.model';
import {Stagiaire} from './stagiaire.model';

export class Formation {

  public id: number;
  public titre: string;
  public dateDebut: string;
  public dateFin: string;

  public salle: Salle;
  public projecteur: Projecteur;
  public gestionnaire: Gestionnaire;
  public programmes: Programme[];
  public ordinateurs: Ordinateur[];
  public stagiaires: Stagiaire[];

  constructor() { }
}
