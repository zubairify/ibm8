package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Flight;
import com.ibm.service.FlightService;

@CrossOrigin
@RestController
public class FlightController {
	
	@Autowired
	private FlightService service;
	
	// http://localhost:8880/flight
	@PostMapping(value = "/flight", consumes = "application/json")
	public String addFlight(@RequestBody Flight f) {
		int code = service.save(f);
		return "Flight added with code: " + code;
	}

	// http://localhost:8880/flight/123
	@GetMapping(value = "/flight/{code}", produces = "application/json")
	public Flight getFlight(@PathVariable int code) {
		return service.fetch(code);
	}
	
	// http://localhost:8880/flights
	@GetMapping(value = "/flights", produces = "application/json")
	public List<Flight> getAll() {
		return service.list();
	}
	
	// http://localhost:8880/carrier/Jet
	@GetMapping(value = "/carrier/{carrier}", produces = "application/json")
	public List<Flight> getByCarrier(@PathVariable String carrier) {
		return service.byCarrier(carrier);
	}
	
	// http://localhost:8880/route?source=Mumbai&destiny=Goa
	@GetMapping(value = "/route", produces = "application/json")
	public List<Flight> getByRoute(@RequestParam String source, @RequestParam String destiny) {
		return service.byRoute(source, destiny);
	}
	
	// http://localhost:8880/flight/123
	@DeleteMapping(value = "/flight/{code}")
	public String remove(@PathVariable int code) {
		service.delete(code);
		return "Flight delete with code: " + code;
	}
}
