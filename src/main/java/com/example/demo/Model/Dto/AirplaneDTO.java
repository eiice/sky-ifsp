package com.example.demo.Model.Dto;

import java.util.Arrays;
import java.util.List;

public class AirplaneDTO {
	private int seats; //seat
	private String plane; //aeronave
	
	public AirplaneDTO(int seats, String plane) {
		super();
		this.seats = seats;
		this.plane = plane;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getPlane() {
		return plane;
	}

	public void setPlane(String plane) {
		this.plane = plane;
	}
	
	public List<Object> getProperties(){
		return Arrays.asList(this.getPlane(), this.getSeats()));
	}
}
