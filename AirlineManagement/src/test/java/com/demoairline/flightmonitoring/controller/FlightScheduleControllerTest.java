package com.demoairline.flightmonitoring.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.demoairline.flightmonitoring.dto.CancelScheduleDto;
import com.demoairline.flightmonitoring.dto.ScheduleResponseDto;
import com.demoairline.flightmonitoring.entity.Airport;
import com.demoairline.flightmonitoring.entity.Flight;
import com.demoairline.flightmonitoring.entity.FlightSchedule;
import com.demoairline.flightmonitoring.exception.FlightScheduleAlreadyDeletedException;
import com.demoairline.flightmonitoring.exception.FlightScheduleNotFound;
import com.demoairline.flightmonitoring.exception.RunwayNotFound;
import com.demoairline.flightmonitoring.service.FlightScheduleService;
import com.demoairline.flightmonitoring.web.controller.FlightScheduleController;

@RunWith(MockitoJUnitRunner.class)
public class FlightScheduleControllerTest {
	@Mock
	private FlightScheduleService flightScheduleService;
	@InjectMocks
	private FlightScheduleController scheduleController;

	@Test
	public void tesCancelSchedule() throws FlightScheduleNotFound, RunwayNotFound, FlightScheduleAlreadyDeletedException {
		FlightSchedule schedule = new FlightSchedule();
		schedule.setScheduleId(1000L);
		schedule.setRunwayID(1234L);
		schedule.setScheduleStatus("available");
		schedule.setScheduleType("Arrival");
		CancelScheduleDto cancelScheduleDto = new CancelScheduleDto();
		cancelScheduleDto.setMeassge("cancel sucessfully");
		cancelScheduleDto.setStatusCode(499L);
		Mockito.when(flightScheduleService.cancelScheduleByScheduleId(1000L)).thenReturn(cancelScheduleDto);
		ResponseEntity<CancelScheduleDto> response = scheduleController.cancelSchedule(1000L);
		assertEquals(cancelScheduleDto.getMeassge(), response.getBody().getMeassge());

	}

	private Long scheduleId;

	private LocalDateTime scheduledDateTime;

	private String scheduleType;

	private Long runwayID;

	private String scheduleStatus;

	@Test
	public void testFlightScheduleByFlightCode() throws RunwayNotFound, FlightScheduleNotFound {
		FlightSchedule flightSchedule = new FlightSchedule();
		flightSchedule.setFlightCode("fhf");
		ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto();
		scheduleResponseDto.setScheduleId(1000L);
		scheduleResponseDto.setScheduleType("commercial");
		scheduleResponseDto.setRunwayID(1L);
		scheduleResponseDto.setScheduleStatus("available");
		List<ScheduleResponseDto> Listschedule = new ArrayList<ScheduleResponseDto>();
		Listschedule.add(scheduleResponseDto);
		Mockito.when(flightScheduleService.getFlightScheduleByFlightCode("fhf")).thenReturn(Listschedule);
		ResponseEntity<List<ScheduleResponseDto>>response=scheduleController.getScheduleByFlightCode("fhf");
		assertEquals(Listschedule.size(), response.getBody().size());
	}

}
