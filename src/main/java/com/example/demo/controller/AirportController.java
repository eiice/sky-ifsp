package com.example.demo.controller;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.model.Airport;
import com.example.demo.service.AirportService;
import javax.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/airport")
public class AirportController {
    @Autowired
    AirportService airportService;
    @GetMapping("/list")
    public ResponseEntity<List<Airport>> List()
    {
        return ResponseEntity.ok(airportService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport>  Get(@Valid @PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(airportService.read(id));
    }

    @PostMapping("")
    public void Post(@RequestBody Airport airport){
        airportService.update(airport);
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
