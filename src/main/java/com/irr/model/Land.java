package com.irr.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "land")
public class Land {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String code;
	private float area;
	private String landType;
	private String agricType;
	private Date createdOn;
	private Date modifiedOn;
	@OneToMany(mappedBy = "land")
	private List<LandConfiguration> landConfiguration;

	public Land(Long id, String code, float area, String landType, String agricType, Date createdOn, Date modifiedOn,
			List<LandConfiguration> landConfiguration) {

		super();
		this.id = id;
		this.code = code;
		this.area = area;
		this.landType = landType;
		this.agricType = agricType;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
		this.landConfiguration = landConfiguration;
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

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn  ) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public List<LandConfiguration> getLandConfigurations() {
		return landConfiguration;
	}

	public void setLandConfigurations(List<LandConfiguration> landConfiguration) {
		this.landConfiguration = landConfiguration;
	}

	public Land() {
		super();
	}
	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("land code : "+this.code);
		return buffer.toString();
	}
}
