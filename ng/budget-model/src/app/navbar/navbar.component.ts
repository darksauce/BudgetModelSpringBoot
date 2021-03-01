import { Component, OnInit } from '@angular/core';
import { faChartLine, faCoffee, faCoins, faCreditCard, faListAlt } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  faCoffee = faCoffee;
  faListAlt = faListAlt;
  faCoins = faCoins;
  faCreditCard = faCreditCard;
  faChartLine = faChartLine;

  constructor() { }

  ngOnInit(): void {
  }

}
