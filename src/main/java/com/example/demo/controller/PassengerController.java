package com.example.demo.controller;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.model.Passenger;
import com.example.demo.model.dto.PassengerDto;
import com.example.demo.service.PassengerService;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passenger")
@Validated
public class PassengerController {
    PassengerService passengerService;
    private ModelMapper modelMapper;

    public PassengerController(PassengerService passengerService, ModelMapper modelMapper) {
        this.passengerService = passengerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/list")
    public ResponseEntity<List<PassengerDto>> List()
    {
        List<Passenger> passengers = passengerService.list();
        List<PassengerDto> passengerDtos = modelMapper.map(passengers, new TypeToken<List<PassengerDto>>() {}.getType());
        return ResponseEntity.ok(passengerDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  Get(@PathVariable("id") Integer id)
    {
        try {
            Passenger passenger = passengerService.read(id);
            PassengerDto passengerDto = modelMapper.map(passenger, PassengerDto.class);
            return ResponseEntity.ok(passengerDto);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("")
    public ResponseEntity<?>  Post(@Valid @RequestBody Passenger passenger){
        passengerService.update(passenger);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> Put(@Valid @RequestBody Passenger passenger, @PathVariable Integer id) {
        try {
            Passenger existingPassenger = passengerService.read(id);
            passenger.setId(id);
            passengerService.update(passenger);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        passengerService.delete(id);
    }
}
