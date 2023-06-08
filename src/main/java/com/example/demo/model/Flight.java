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
@Table(name= "flights")
public class Flight extends BaseEntity{
    @NotNull
    private Date departureDate;
    @NotNull
    private Date arrivalDate;
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
    @JoinColumn(name = "origin_id")
    private Airport origin;
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
    @JoinColumn(name = "destination_id")
    private Airport destination;
    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;
}
