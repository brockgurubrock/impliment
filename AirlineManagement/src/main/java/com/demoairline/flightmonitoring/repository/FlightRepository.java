package com.demoairline.flightmonitoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoairline.flightmonitoring.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long>{

}
