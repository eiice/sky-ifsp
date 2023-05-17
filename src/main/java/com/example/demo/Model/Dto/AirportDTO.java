package com.example.demo.Model.Dto;

import java.util.Arrays;
import java.util.List;

public class AirportDTO {
	private String country;
	private String name; 
	private String latitude;
	private String longitude;
	
	public AirportDTO(String country, String name, String latitude, String longitude) {
		super();
		this.country = country;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public List<Object> getProperties(){
		return Arrays.asList(this.getCountry(), this.getLatitude(), this.getLongitude(), this.getName()));
	}
}

