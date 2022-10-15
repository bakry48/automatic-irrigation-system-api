package com.irr.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "landconfig")
public class LandConfiguration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String deviceName;
	private Date startDate;
	private Date endDate;
	private Integer intervalInDays;
	private Integer amountOfWater;
	private Date createdOn;
	private Date modifiedOn;
	@ManyToOne
	private Land land;
	public LandConfiguration(Long id, String deviceName, Date endDate, Integer intervalInDays,
			Integer durationInMinutes, Integer amountOfWater, Date startDate, Date createdOn, Date modifiedOn,
			Land land) {
		super();
		this.id = id;
		this.deviceName = deviceName;
		this.startDate = startDate;
		this.intervalInDays = intervalInDays;
		this.amountOfWater = amountOfWater;
		this.endDate = endDate;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
		this.land = land;
	}

	public LandConfiguration() {
		super();
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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


	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Land getLand() {
		return land;
	}

	public void setLand(Land land) {
		this.land = land;
	}

	
	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("Device name : "+this.deviceName);
		return buffer.toString();
	}

}
