package com.demoairline.flightmonitoring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Runway")
public class Runway implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long runwayID;
	
	@Column(name="runway")
	@NotNull
	private String runway;
	
	@Column(name="runway_status")
	@NotNull
	private String runwayStatus;	
	

	public Long getRunwayID() {
		return runwayID;
	}

	public void setRunwayID(Long runwayID) {
		this.runwayID = runwayID;
	}

	public String getRunway() {
		return runway;
	}

	public void setRunway(String runway) {
		this.runway = runway;
	}

	public String getRunwayStatus() {
		return runwayStatus;
	}

	public void setRunwayStatus(String runwayStatus) {
		this.runwayStatus = runwayStatus;
	}

	
}
