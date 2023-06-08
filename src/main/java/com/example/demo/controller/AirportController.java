package com.example.demo.controller;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.model.Airport;
import com.example.demo.model.dto.AirportDto;
import com.example.demo.service.AirportService;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airport")
@Validated
public class AirportController {
    AirportService airportService;
    private ModelMapper modelMapper;

    public AirportController(AirportService airportService, ModelMapper modelMapper) {
        this.airportService = airportService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/list")
    public ResponseEntity<List<AirportDto>> List()
    {
        List<Airport> airports = airportService.list();
        List<AirportDto> airportDtos = modelMapper.map(airports, new TypeToken<List<AirportDto>>() {}.getType());
        return ResponseEntity.ok(airportDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  Get(@PathVariable("id") Integer id)
    {
        try {
            Airport airport = airportService.read(id);
            AirportDto airportDto = modelMapper.map(airport, AirportDto.class);
            return ResponseEntity.ok(airportDto);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("")
    public ResponseEntity<?>  Post(@Valid @RequestBody Airport airport){
        airportService.update(airport);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> Put(@Valid @RequestBody Airport airport, @PathVariable Integer id) {
        try {
            Airport existingAirport = airportService.read(id);
            airport.setId(id);
            airportService.update(airport);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        airportService.delete(id);
    }
}
