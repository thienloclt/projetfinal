import {Injectable} from '@angular/core';

@Injectable()
export class Globals {
  public theme = Themes.BLUE;
}

export enum Themes {
  RED = 'danger',
  BLUE = 'info',
  GREEN = 'success',
  YELLOW = 'warning'
}
