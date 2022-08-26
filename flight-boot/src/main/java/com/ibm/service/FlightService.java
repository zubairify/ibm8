package com.ibm.service;

import java.util.List;

import com.ibm.entity.Flight;

public interface FlightService {

	int save(Flight f);
	
	Flight fetch(int code);
	
	List<Flight> list();
	
	void delete(int code);
	
	List<Flight> byCarrier(String carrier);
	
	List<Flight> byRoute(String source, String destiny);
}
