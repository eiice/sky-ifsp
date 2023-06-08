package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name= "tickets")
public class Ticket extends BaseEntity{
    @Column(columnDefinition = "boolean default false")
    private boolean hasBeenUsed;
    @OneToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;
    private String type;
}
