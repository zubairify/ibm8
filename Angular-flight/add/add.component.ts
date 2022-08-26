import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Flight } from '../model/flight.model';
import { FlightService } from '../services/flight.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  flight : Flight = new Flight();
  carriers : string[] = ["Indigo", "Jet", "AirIndia"];
  cities : string[] = ["Mumbai","Chennai","Delhi","Kolkata","Hyderabad","Goa"];

  constructor(private service : FlightService, private router : Router) { }

  ngOnInit(): void {
  }

  save() {
    // logic to save flight
    this.service.add(this.flight);
    this.router.navigate(['list']);
  }
}
