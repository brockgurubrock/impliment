package com.demoairline.flightmonitoring.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demoairline.flightmonitoring.constant.Constant;
import com.demoairline.flightmonitoring.dto.CancelScheduleDto;
import com.demoairline.flightmonitoring.dto.ScheduleResponseDto;
import com.demoairline.flightmonitoring.entity.FlightSchedule;
import com.demoairline.flightmonitoring.entity.Runway;
import com.demoairline.flightmonitoring.exception.FlightScheduleNotFound;
import com.demoairline.flightmonitoring.exception.RunwayNotFound;
import com.demoairline.flightmonitoring.repository.FlightScheduleRepository;
import com.demoairline.flightmonitoring.repository.RunwayRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
@Transactional
public class FlightScheduleServiceImpl implements FlightScheduleService {
	@Autowired
	private FlightScheduleRepository flightScheduleRepository;
	@Autowired
	private RunwayRepository runwayRepository;

	@Override
	public CancelScheduleDto cancelScheduleByScheduleId(Long ScheduleId) throws FlightScheduleNotFound, RunwayNotFound {
		Optional<FlightSchedule> flightSchedule = flightScheduleRepository.findById(ScheduleId);
		if (!flightSchedule.isPresent()) {
			throw new FlightScheduleNotFound(Constant.FlightScheduleNotFoud);
		}

		flightSchedule.get().setScheduleStatus("deleted");
		flightScheduleRepository.save(flightSchedule.get());
		Optional<Runway> runway = runwayRepository.findById(flightSchedule.get().getRunwayID());
		if (!runway.isPresent()) {
			throw new RunwayNotFound("RunwayNotFound");
		}
		runway.get().setRunwayStatus("not available");

		CancelScheduleDto cancelScheduleDto = new CancelScheduleDto();
		cancelScheduleDto.setMeassge(Constant.CancelSchedule);
		cancelScheduleDto.setStatusCode(Constant.CancelCode);
		return cancelScheduleDto;
	}

	@Override
	public List<ScheduleResponseDto> getFlightScheduleByFlightCode(String flightCode) {
		List<FlightSchedule> listFlightSchedue = flightScheduleRepository.findAllByFlightCode(flightCode);
		List<ScheduleResponseDto> scheduleResponseDtos = listFlightSchedue.stream().map(schedule -> {
			ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto();
			BeanUtils.copyProperties(listFlightSchedue, scheduleResponseDto);
			return scheduleResponseDto;

		}).collect(Collectors.toList());
		return scheduleResponseDtos;
	}

}
