import { Component, OnInit } from '@angular/core';
import { Flight } from '../model/flight.model';
import { FlightService } from '../services/flight.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  carrier : string = "";
  carriers : string[] = ["Indigo", "Jet", "AirIndia"];
  flights : Flight[] = [];

  constructor(private service : FlightService) { }

  ngOnInit(): void {
  }

  search() {
    this.service.find(this.carrier).then(flts => flts.subscribe(data => this.flights = data));
    // this.flights = this.service.find(this.carrier);
  }
}
