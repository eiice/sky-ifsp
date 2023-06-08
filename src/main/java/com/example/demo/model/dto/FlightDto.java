package com.example.demo.model.dto;

import com.example.demo.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class FlightDto extends BaseEntity{
    private Date departureDate;
    private Date arrivalDate;
    private AirportDto origin;
    private AirportDto destination;
    private AirplaneDto airplane;
}
