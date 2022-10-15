package com.irr.dto;

import java.util.List;


public class LandDTO {

	private Long id;
	private String code;
	private String landType;
	private String agricType;
	private float area;
	private List<LandConfigurationDTO> landConfigurations;
	
	public LandDTO(Long id, String code, String landType, String agricType, float area,
			List<LandConfigurationDTO> landConfigurations) {
		super();
		this.id = id;
		this.code = code;
		this.landType = landType;
		this.agricType = agricType;
		this.area = area;
		this.landConfigurations = landConfigurations;
	}
	public LandDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLandType() {
		return landType;
	}
	public void setLandType(String landType) {
		this.landType = landType;
	}
	public String getAgricType() {
		return agricType;
	}
	public void setAgricType(String agricType) {
		this.agricType = agricType;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public List<LandConfigurationDTO> getLandConfigurations() {
		return landConfigurations;
	}
	public void setLandConfigurations(List<LandConfigurationDTO> landConfigurations) {
		this.landConfigurations = landConfigurations;
	}
	
}
