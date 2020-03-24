package com.demoairline.flightmonitoring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionDto {
	@JsonProperty("message")
	private String message;
	@JsonProperty("StatusCode")
	private Long StatusCode;
	@JsonProperty("message")
	public String getMessage() {
		return message;
	}
	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}
	@JsonProperty("StatusCode")
	public Long getStatusCode() {
		return StatusCode;
	}
	@JsonProperty("StatusCode")
	public void setStatusCode(Long statusCode) {
		StatusCode = statusCode;
	}

}
