package com.demoairline.flightmonitoring.dto;

public class CancelScheduleDto {
	private String meassge;
	private Long statusCode;

	public String getMeassge() {
		return meassge;
	}

	public void setMeassge(String meassge) {
		this.meassge = meassge;
	}

	public Long getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Long cancelcode) {
		this.statusCode = cancelcode;
	}

}
