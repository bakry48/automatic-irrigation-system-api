package com.irr.dto;

import java.util.Date;
import java.util.List;

import com.irr.model.IrrigationTransactions;

public class LandConfigurationDTO {
	private Long id;
	private String deviceName;
    private Date startDate;
    private Date endDate;
    private Integer intervalInDays;
    private Integer amountOfWater;
    private List<IrrigationTransactions> irrigationTransactions;
    private Date createdOn;
    private Date modifiedOn;
    
	public LandConfigurationDTO(Long id, String deviceName, Date endDate, Integer intervalInDays,
			Integer durationInMinutes, Integer amountOfWater, Date startDate, Date createdOn, Date modifiedOn) {
		super();
		this.id = id;
		this.deviceName = deviceName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.intervalInDays = intervalInDays;
		this.amountOfWater = amountOfWater;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
		
		
	}
	public LandConfigurationDTO() {
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
	public List<IrrigationTransactions> getIrrigationTransactions() {
		return irrigationTransactions;
	}
	public void setIrrigationTransactions(List<IrrigationTransactions> irrigationTransactions) {
		this.irrigationTransactions = irrigationTransactions;
	}
}
