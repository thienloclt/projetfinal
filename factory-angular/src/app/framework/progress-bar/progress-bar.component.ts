import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-progress-bar',
  templateUrl: './progress-bar.component.html',
  styleUrls: ['./progress-bar.component.css']
})
export class ProgressBarComponent implements OnInit {
  value: number = 0;
  display: boolean = false;
  constructor() { }
  @Output() eventemitter: EventEmitter<string> = new EventEmitter<string>();

  ngOnInit() {
  }

  showDialog() {
    this.display = true;
    this.timer();
  }

  timer() {
    let interval = setInterval(() => {
      this.value = this.value + Math.floor(Math.random() * 60) + 30;
      if(this.value >= 100) {
        this.value = 0;
        this.display = false;
        this.eventemitter.emit('tranfere');
        clearInterval(interval);
      }
    }, 1000);
  }
}
