package com.demoairline.flightmonitoring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoairline.flightmonitoring.entity.Flight;
import com.demoairline.flightmonitoring.service.FlightService;

@RestController
@RequestMapping(value = "flight")
public class FlightController {
	@Autowired
	private FlightService flightService;

	@GetMapping(value = "/flights")
	ResponseEntity<List<Flight>> getAllFlights() {

		return new ResponseEntity<List<Flight>>(flightService.getAllflights(), HttpStatus.OK);

	}
	
	

}
