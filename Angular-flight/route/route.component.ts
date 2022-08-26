import { Component, OnInit } from '@angular/core';
import { Flight } from '../model/flight.model';
import { FlightService } from '../services/flight.service';

@Component({
  selector: 'app-route',
  templateUrl: './route.component.html',
  styleUrls: ['./route.component.css']
})
export class RouteComponent implements OnInit {
  source : string = "";
  destiny : string = "";
  cities : string[] = ["Mumbai","Chennai","Delhi","Kolkata","Hyderabad","Goa"];
  flights : Flight[] = [];

  constructor(private service : FlightService) { }

  ngOnInit(): void {
  }

  search() {
    this.service.route(this.source, this.destiny).then(flts => flts.subscribe(data => this.flights = data));
    // this.flights = this.service.route(this.source, this.destiny);
  }
}
