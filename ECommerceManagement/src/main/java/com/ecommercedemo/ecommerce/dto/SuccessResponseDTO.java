package com.ecommercedemo.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuccessResponseDTO {
	@JsonProperty("message")
	String message;
	@JsonProperty("successCode")
	Integer successCode;
	@JsonProperty("message")
	public String getMessage() {
		return message;
	}
	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}
	@JsonProperty("successCode")
	public Integer getSuccessCode() {
		return successCode;
	}
	@JsonProperty("successCode")
	public void setSuccessCode(Integer successCode) {
		this.successCode = successCode;
	}
	

}
