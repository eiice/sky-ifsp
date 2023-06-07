package com.example.demo.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name= "passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    @NotNull
    private int name;
    @NotNull
    private String cpf;
    @NotNull
    private Date birthdate;
    @OneToOne
    @JoinColumn(name = "airplane_id")
    @NotNull
    private Airplane airplane;
    @NotNull
    private String passport;
    @NotNull
    private Date flightDate;
    @NotNull
    private String airline;

    public Passenger() {
    }

    public Passenger(Integer id, @NotNull int name, @NotNull String cpf, @NotNull Date birthdate, @NotNull Airplane airplane, @NotNull String passport, @NotNull Date flightDate, @NotNull String airline) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.birthdate = birthdate;
        this.airplane = airplane;
        this.passport = passport;
        this.flightDate = flightDate;
        this.airline = airline;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}
