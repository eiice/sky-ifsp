package com.example.demo.model.dto;

import com.example.demo.model.BaseEntity;
import com.example.demo.model.Passenger;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TicketDto extends BaseEntity {
    private boolean hasBeenUsed;
    private Passenger passenger;
    private String type;
}
