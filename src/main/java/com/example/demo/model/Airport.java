package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "airports")
public class Airport extends BaseEntity {
    @NotNull
    private String code;
    @NotNull
    private String country;
    @NotNull
    @Column
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
}
