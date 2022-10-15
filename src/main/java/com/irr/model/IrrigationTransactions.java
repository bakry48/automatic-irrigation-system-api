package com.irr.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class IrrigationTransactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer status ;
	private Date runDate;
	@ManyToOne
	private LandConfiguration landConfiguration;
	public IrrigationTransactions() {
		super();
	}
	public IrrigationTransactions(Long id, Integer status, Date runDate, LandConfiguration landConfiguration) {
		super();
		this.id = id;
		this.status = status;
		this.runDate = runDate;
		this.landConfiguration = landConfiguration;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getRunDate() {
		return runDate;
	}
	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}
	public LandConfiguration getLandConfiguration() {
		return landConfiguration;
	}
	public void setLandConfiguration(LandConfiguration landConfiguration) {
		this.landConfiguration = landConfiguration;
	}
}
