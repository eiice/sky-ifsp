package com.example.demo.model.dto;

import com.example.demo.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AirplaneDto extends BaseEntity {
    private String code;
    private int seats;
    private String plane;
}
