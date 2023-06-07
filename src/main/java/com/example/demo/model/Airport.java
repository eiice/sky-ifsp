package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.List;

@Entity
@Table(name= "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    @NotNull
    private String code;
    @NotNull
    private String country;
    @NotNull
    private String countryCode;
    @NotNull
    private String city;
    @NotNull
    private String airport;
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
    @OneToMany(mappedBy = "origin")
    private List<Flight> originFlights;
    @OneToMany(mappedBy = "destination")
    private List<Flight> destinationFlights;

    public Airport() {

    }

    public Airport(Integer id, @NotNull String code, @NotNull String country, @NotNull String countryCode, @NotNull String city, @NotNull String airport, @NotNull Double latitude, @NotNull Double longitude, List<Flight> originFlights, List<Flight> destinationFlights) {
        this.id = id;
        this.code = code;
        this.country = country;
        this.countryCode = countryCode;
        this.city = city;
        this.airport = airport;
        this.latitude = latitude;
        this.longitude = longitude;
        this.originFlights = originFlights;
        this.destinationFlights = destinationFlights;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<Flight> getOriginFlights() {
        return originFlights;
    }

    public void setOriginFlights(List<Flight> originFlights) {
        this.originFlights = originFlights;
    }

    public List<Flight> getDestinationFlights() {
        return destinationFlights;
    }

    public void setDestinationFlights(List<Flight> destinationFlights) {
        this.destinationFlights = destinationFlights;
    }
}
