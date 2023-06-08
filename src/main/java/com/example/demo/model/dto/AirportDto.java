package com.example.demo.model.dto;

import com.example.demo.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AirportDto extends BaseEntity {
    private String code;
    private String country;
    private String countryCode;
    private String city;
    private String airport;
    private Double latitude;
    private Double longitude;
}
