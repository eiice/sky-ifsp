package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name= "passengers")
public class Passenger extends BaseEntity{
    @NotNull
    private String name;
    @NotNull
    private String cpf;
    @NotNull
    private Date birthdate;
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;
    @NotNull
    private String passport;
    @NotNull
    private Date flightDate;
    @NotNull
    private String airline;
}
