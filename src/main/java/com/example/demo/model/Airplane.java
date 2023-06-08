package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "airplanes")
public class Airplane extends BaseEntity{
    @NotNull
    private String code;
    @NotNull
    private int seats;
    @NotNull
    private String plane;
    @OneToMany(mappedBy = "airplane", fetch = FetchType.LAZY )
    private List<Flight> flights;
    @OneToMany(mappedBy = "airplane", fetch = FetchType.LAZY )
    private List<Passenger> passengers;
}
