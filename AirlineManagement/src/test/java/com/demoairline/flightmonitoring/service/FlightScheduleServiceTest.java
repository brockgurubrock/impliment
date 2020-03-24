package com.demoairline.flightmonitoring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.demoairline.flightmonitoring.dto.CancelScheduleDto;
import com.demoairline.flightmonitoring.dto.ScheduleResponseDto;
import com.demoairline.flightmonitoring.entity.Airline;
import com.demoairline.flightmonitoring.entity.Airport;
import com.demoairline.flightmonitoring.entity.Flight;
import com.demoairline.flightmonitoring.entity.FlightSchedule;
import com.demoairline.flightmonitoring.entity.Runway;
import com.demoairline.flightmonitoring.exception.FlightScheduleAlreadyDeletedException;
import com.demoairline.flightmonitoring.exception.FlightScheduleNotFound;
import com.demoairline.flightmonitoring.exception.RunwayNotFound;
import com.demoairline.flightmonitoring.repository.FlightScheduleRepository;
import com.demoairline.flightmonitoring.repository.RunwayRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class FlightScheduleServiceTest {
	@Mock
	private FlightScheduleRepository flightScheduleRepository;
	@Mock
	private RunwayRepository runwayRepository;
	@InjectMocks
	private FlightScheduleServiceImpl scheduleServiceImpl;
	
@Test	
public void testFlightScheduleCancel() throws FlightScheduleNotFound, RunwayNotFound, FlightScheduleAlreadyDeletedException
{
	FlightSchedule schedule=new FlightSchedule();
	schedule.setScheduleId(1000L);
	schedule.setRunwayID(1234L);
	schedule.setScheduleStatus("available");
	schedule.setScheduleType("Arrival");
	Flight flight=new Flight();
	flight.setFlightId(1L);
	flight.setFlightName("abc");
	Airline airline=new Airline();
	airline.setAirlineId(1L);
	schedule.setRunwayID(1L);
	Runway runway=new Runway();
	runway.setRunwayID(1L);
	Airport airport=new Airport();
	airport.setAirportId(1L);
	Mockito.when(flightScheduleRepository.findById(1000L)).thenReturn(Optional.of(schedule));
	Mockito.when(runwayRepository.findById(1L)).thenReturn(Optional.of(runway));
	CancelScheduleDto response=scheduleServiceImpl.cancelScheduleByScheduleId(1000L);
	assertEquals("The Schedule flight is being canceled", response.getMeassge());
	
	
	
}
@Test	

public void testFlightScheduleNotFound() throws FlightScheduleNotFound, RunwayNotFound
{
	FlightSchedule schedule=new FlightSchedule();
	schedule.setScheduleId(1000L);
	schedule.setRunwayID(1234L);
	schedule.setScheduleStatus("available");
	schedule.setScheduleType("Arrival");
	Flight flight=new Flight();
	flight.setFlightId(1L);
	flight.setFlightName("abc");
	Airline airline=new Airline();
	airline.setAirlineId(1L);
	schedule.setRunwayID(1L);
	Runway runway=new Runway();
	runway.setRunwayID(1L);
	Airport airport=new Airport();
	airport.setAirportId(1L);
	Mockito.when(flightScheduleRepository.findById(1000L)).thenReturn(Optional.of(schedule));
	Mockito.when(runwayRepository.findById(1L)).thenReturn(Optional.of(runway));

	assertThrows(FlightScheduleNotFound.class,()->
	{scheduleServiceImpl.cancelScheduleByScheduleId(10002L);}
			
			)	;
}
@Test	
public void testFlightScheduleAlreadyDeletedException() throws FlightScheduleNotFound, RunwayNotFound
{
	FlightSchedule schedule=new FlightSchedule();
	schedule.setScheduleId(1000L);
	schedule.setRunwayID(1234L);
	schedule.setScheduleStatus("deleted");
	schedule.setScheduleType("Arrival");
	Flight flight=new Flight();
	flight.setFlightId(1L);
	flight.setFlightName("abc");
	Airline airline=new Airline();
	airline.setAirlineId(1L);
	schedule.setRunwayID(1L);
	Runway runway=new Runway();
	runway.setRunwayID(1L);
	Airport airport=new Airport();
	airport.setAirportId(1L);
	Mockito.when(flightScheduleRepository.findById(1000L)).thenReturn(Optional.of(schedule));
	Mockito.when(runwayRepository.findById(1L)).thenReturn(Optional.of(runway));

	assertThrows(FlightScheduleAlreadyDeletedException.class,()->
	{scheduleServiceImpl.cancelScheduleByScheduleId(1000L);}
			
			)	;
}
@Test	
public void testRunwayNotFoundException() throws FlightScheduleNotFound, RunwayNotFound
{
	FlightSchedule schedule=new FlightSchedule();
	schedule.setScheduleId(1000L);
	
	schedule.setScheduleStatus("available");
	schedule.setScheduleType("Arrival");
	Flight flight=new Flight();
	flight.setFlightId(1L);
	flight.setFlightName("abc");
	Airline airline=new Airline();
	airline.setAirlineId(1L);
	schedule.setRunwayID(2L);
	Runway runway=new Runway();
	runway.setRunwayID(1L);
	Airport airport=new Airport();
	airport.setAirportId(1L);
	Mockito.when(flightScheduleRepository.findById(1000L)).thenReturn(Optional.of(schedule));
	Mockito.when(runwayRepository.findById(1L)).thenReturn(Optional.of(runway));

	assertThrows(RunwayNotFound.class,()->
	{scheduleServiceImpl.cancelScheduleByScheduleId(1000L);}
			
			)	;
}
	@Test
	public void testGetFlightScheduleByFlightCode()
	{
		
	FlightSchedule flightSchedule = new FlightSchedule();
	flightSchedule.setFlightCode("fhf");
	List<FlightSchedule> listflight=new ArrayList<FlightSchedule>();
	listflight.add(flightSchedule);
	ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto();
	scheduleResponseDto.setScheduleId(1000L);
	scheduleResponseDto.setScheduleType("commercial");
	scheduleResponseDto.setRunwayID(1L);
	scheduleResponseDto.setScheduleStatus("available");
	List<ScheduleResponseDto> Listschedule = new ArrayList<ScheduleResponseDto>();
	Listschedule.add(scheduleResponseDto);
	Mockito.when(flightScheduleRepository.findAllByFlightCode("fhf")).thenReturn(listflight);
	List<ScheduleResponseDto> responseDto=scheduleServiceImpl.getFlightScheduleByFlightCode("fhf");
	assertEquals(listflight.size(), responseDto.size());
	
	}
	
}
	
	
	

