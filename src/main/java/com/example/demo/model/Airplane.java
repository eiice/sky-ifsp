package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "airplanes")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    @NotNull
    private String code;
    @NotNull
    private int seats;
    @NotNull
    private String plane;
    @OneToMany(mappedBy = "airplane")
    private List<Flight> flights;
    @NotNull
    @OneToMany(mappedBy = "airplane")
    private List<Passenger> passengers;

    public Airplane(Integer id, @NotNull String code, @NotNull int seats, @NotNull String plane, List<Flight> flights, @NotNull List<Passenger> passengers) {
        this.id = id;
        this.code = code;
        this.seats = seats;
        this.plane = plane;
        this.flights = flights;
        this.passengers = passengers;
    }

    public Airplane() {
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

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
