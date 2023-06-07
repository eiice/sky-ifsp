package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name= "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    @NotNull
    private Date departureDate;
    @NotNull
    private Date arrivalDate;
    @OneToOne
    @NotNull
    @JoinColumn(name = "origin_id")
    private Airport origin;
    @OneToOne
    @NotNull
    @JoinColumn(name = "destination_id")
    private Airport destination;
    @NotNull
    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    public Flight(Integer id, @NotNull Date departureDate, @NotNull Date arrivalDate, @NotNull Airport origin, @NotNull Airport destination, @NotNull Airplane airplane) {
        this.id = id;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.origin = origin;
        this.destination = destination;
        this.airplane = airplane;
    }

    public Flight() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
}
