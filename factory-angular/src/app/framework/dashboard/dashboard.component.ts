import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  data: any;

  constructor() {
    this.data = {
      labels: ['Disponible', 'Occupant'],
      datasets: [
        {
          data: [286, 121],
          backgroundColor: [
            "#FF6384",
            "#FFCE56"
          ],
          hoverBackgroundColor: [
            "#FF6384",
            "#FFCE56"
          ]
        }]
    };
  }

  ngOnInit() {
  }
}
