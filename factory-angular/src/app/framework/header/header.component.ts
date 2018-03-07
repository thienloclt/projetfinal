import { Component, OnInit } from '@angular/core';
import {Globals, Themes} from '../globals';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  color: Themes = Themes.BLUE;

  constructor(public globals: Globals) { }

  ngOnInit() {
  }

  changeThemes(theme: Themes): void {
    this.globals.theme = theme;
  }
}
