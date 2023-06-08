package com.example.demo.model.dto;

import com.example.demo.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PassengerDto extends BaseEntity {
    private String name;
    private String cpf;
    private Date birthdate;
    private String passport;
    private Date flightDate;
    private String airline;

}
