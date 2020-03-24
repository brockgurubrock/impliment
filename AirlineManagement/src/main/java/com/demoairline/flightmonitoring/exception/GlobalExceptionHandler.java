package com.demoairline.flightmonitoring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demoairline.flightmonitoring.constant.Constant;
import com.demoairline.flightmonitoring.dto.ExceptionDto;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(FlightScheduleAlreadyDeletedException.class)
	ResponseEntity<ExceptionDto>flightScheduleAlreadyDeleted(FlightScheduleAlreadyDeletedException ex)
	{
		ExceptionDto exceptionDto=new ExceptionDto();
		exceptionDto.setMessage(ex.getMessage());
		exceptionDto.setStatusCode(Constant.FlightScheduleDeletedCode);
		return new ResponseEntity<>(exceptionDto,HttpStatus.OK);
	}
	@ExceptionHandler(FlightScheduleNotFound.class)
	ResponseEntity<ExceptionDto>flightScheduleNotFound(FlightScheduleNotFound ex)
	{
		ExceptionDto exceptionDto=new ExceptionDto();
		exceptionDto.setMessage(ex.getMessage());
		exceptionDto.setStatusCode(Constant.FlightScheduleNotfoudCode);
		return new ResponseEntity<>(exceptionDto,HttpStatus.OK);
	}
	@ExceptionHandler(RunwayNotFound.class)
	ResponseEntity<ExceptionDto>runwayNotFound(RunwayNotFound ex)
	{
		ExceptionDto exceptionDto=new ExceptionDto();
		exceptionDto.setMessage(ex.getMessage());
		exceptionDto.setStatusCode(Constant.RunWayNotFound);
		return new ResponseEntity<>(exceptionDto,HttpStatus.OK);
	}
	

}
