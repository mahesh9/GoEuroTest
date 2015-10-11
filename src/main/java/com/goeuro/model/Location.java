package com.goeuro.model;

import java.io.Serializable;

public class Location implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String type;
	private String latitude;
	private String longitude;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String logitude) {
		this.longitude = logitude;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", type=" + type + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}

}
