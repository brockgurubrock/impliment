package com.demoairline.flightmonitoring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demoairline.flightmonitoring.dto.CancelScheduleDto;
import com.demoairline.flightmonitoring.dto.ScheduleResponseDto;
import com.demoairline.flightmonitoring.exception.FlightScheduleNotFound;
import com.demoairline.flightmonitoring.exception.RunwayNotFound;
import com.demoairline.flightmonitoring.service.FlightScheduleService;

@RestController
@RequestMapping("/flightSchedule")
public class FlightScheduleController {
	@Autowired
	private FlightScheduleService flightScheduleService;

	@DeleteMapping("/{scheduleId}")
	public ResponseEntity<CancelScheduleDto> cancelSchedule(@PathVariable("scheduleId") Long scheduleId)throws RunwayNotFound
			, FlightScheduleNotFound {

		CancelScheduleDto cancelScheduleDto = flightScheduleService.cancelScheduleByScheduleId(scheduleId);

		return new ResponseEntity<>(cancelScheduleDto, HttpStatus.NO_CONTENT);

	}

	@GetMapping("/{scheduleId}")
	public ResponseEntity<List<ScheduleResponseDto>> getScheduleByFlightCode(@RequestParam("flightCode") String flightCode)throws RunwayNotFound
			, FlightScheduleNotFound {

		List<ScheduleResponseDto>scheduleResponseDtos = flightScheduleService.getFlightScheduleByFlightCode(flightCode);

		return new ResponseEntity<List<ScheduleResponseDto>>(scheduleResponseDtos,HttpStatus.OK);

	
}
}
