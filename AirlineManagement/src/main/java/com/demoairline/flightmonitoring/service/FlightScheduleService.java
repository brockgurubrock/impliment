package com.demoairline.flightmonitoring.service;

import java.util.List;

import com.demoairline.flightmonitoring.dto.CancelScheduleDto;
import com.demoairline.flightmonitoring.dto.ScheduleResponseDto;
import com.demoairline.flightmonitoring.entity.FlightSchedule;
import com.demoairline.flightmonitoring.exception.FlightScheduleAlreadyDeletedException;
import com.demoairline.flightmonitoring.exception.FlightScheduleNotFound;
import com.demoairline.flightmonitoring.exception.RunwayNotFound;

public interface FlightScheduleService {

	public CancelScheduleDto cancelScheduleByScheduleId(Long ScheduleId) throws FlightScheduleNotFound, RunwayNotFound,FlightScheduleAlreadyDeletedException;

	public List<ScheduleResponseDto> getFlightScheduleByFlightCode(String flightCode);
}
