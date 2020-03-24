package com.demoairline.flightmonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demoairline.flightmonitoring.entity.Flight;
import com.demoairline.flightmonitoring.repository.FlightRepository;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public List<Flight> getAllflights() {
		List<Flight> flightList=flightRepository.findAll();
		return flightList;
	}

}
