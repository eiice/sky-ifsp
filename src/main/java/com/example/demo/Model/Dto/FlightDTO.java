package com.example.demo.Model.Dto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FlightDTO extends BaseDTO{
	private AirportDTO outward; //ida
	private AirportDTO outbound; //partida
	private Date departureTime; //horário de partida
	private Date arrivalTime; //horário de chegada
	private AirplaneDTO airplane; //avião

	public FlightDTO(AirportDTO outward, AirportDTO outbound, Date departureTime, Date arrivalTime,
			AirplaneDTO airplane) {
		super();
		this.outward = outward;
		this.outbound = outbound;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.airplane = airplane;
	}
	
	public FlightDTO(){

	}

	public AirportDTO getOutward() {
		return outward;
	}

	public void setOutward(AirportDTO outward) {
		this.outward = outward;
	}

	public AirportDTO getOutbound() {
		return outbound;
	}

	public void setOutbound(AirportDTO outbound) {
		this.outbound = outbound;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public AirplaneDTO getAirplane() {
		return airplane;
	}

	public void setAirplane(AirplaneDTO airplane) {
		this.airplane = airplane;
	}
}
