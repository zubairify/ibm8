package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	// Select * from flights where carrier="carrier"
	List<Flight> findByCarrier(String carrier);
	
	List<Flight> findBySourceAndDestiny(String src, String dest);
}
