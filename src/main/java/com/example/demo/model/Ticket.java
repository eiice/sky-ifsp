package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "tickets")
public class Ticket {
    @Column(columnDefinition = "boolean default false")
    private boolean hasBeenUsed;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "passenger_id")
    @NotNull
    private Passenger passenger;
    private String type;

    public Ticket() {
    }

    public Ticket(boolean hasBeenUsed, Integer id, @NotNull Passenger passenger, String type) {
        this.hasBeenUsed = hasBeenUsed;
        this.id = id;
        this.passenger = passenger;
        this.type = type;
    }

    public boolean isHasBeenUsed() {
        return hasBeenUsed;
    }

    public void setHasBeenUsed(boolean hasBeenUsed) {
        this.hasBeenUsed = hasBeenUsed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
