import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Flight } from '../model/flight.model';

@Injectable({
  providedIn: 'root'
})
export class FlightService {
  // flights : Flight[] = [];
  private static url : string = "http://localhost:8880";

  constructor(private http : HttpClient) { }

  add(flight : Flight) {
    this.http.post(FlightService.url + "/flight", flight).subscribe(data => data = flight);
    // this.flights.push(flight);
  }

  async list() {
    return await this.http.get<Flight[]>(FlightService.url + "/flights");
    // return this.flights;
  }

  remove(code : number) {
    this.http.delete(FlightService.url + "/flight/" + code).subscribe();
    // return this.flights.splice(idx, 1);
  }

  async find(carrier : string) {
    return await this.http.get<Flight[]>(FlightService.url + "/carrier/" + carrier);
    // return this.flights.filter(f => f.carrier == carrier);
  }

  async route(source : string, destiny : string) {
    return await this.http.get<Flight[]>(FlightService.url + "/route?source="+source+"&destiny="+destiny);
    // return this.flights.filter(f => f.source == source && f.destiny == destiny);
  }
}
