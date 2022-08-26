import { Component, OnInit } from '@angular/core';
import { Flight } from '../model/flight.model';
import { FlightService } from '../services/flight.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  flights : Flight[] = [];

  constructor(private service : FlightService) { }

  ngOnInit(): void {
    this.service.list().then(flts => flts.subscribe(data => this.flights = data));
    // this.flights = this.service.list();
  }

  delete(idx : number) {
    var ans = confirm("Are you sure to delete?")
    if(ans)
      this.service.remove(idx);
  }
}
