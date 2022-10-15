package com.irr.dto;

import java.util.Date;

public class ConfigureLandDTO {

	private String deviceName;
	private Date startDate;
	private Date endDate;
	private Integer intervalInDays;
	private Integer amountOfWater;

	public ConfigureLandDTO(String deviceName, Date startDate, Date endDate,  Integer intervalInDays,
			Integer amountOfWater) {
		super();
		this.deviceName = deviceName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.intervalInDays = intervalInDays;
		this.amountOfWater = amountOfWater;
	}

	public ConfigureLandDTO() {
		super();
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	
	public Integer getIntervalInDays() {
		return intervalInDays;
	}

	public void setIntervalInDays(Integer intervalInDays) {
		this.intervalInDays = intervalInDays;
	}

	public Integer getAmountOfWater() {
		return amountOfWater;
	}

	public void setAmountOfWater(Integer amountOfWater) {
		this.amountOfWater = amountOfWater;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
