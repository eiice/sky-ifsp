package com.example.demo.controller;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.model.Passenger;
import com.example.demo.service.PassengerService;
import javax.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/passenger")
public class PassengerController {
    @Autowired
    PassengerService passengerService;
    @GetMapping("list")
    public ResponseEntity<List<Passenger>> List()
    {
        return ResponseEntity.ok(passengerService.list());
    }

    @GetMapping("{id}")
    public ResponseEntity<Passenger>  Get(@Valid @PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(passengerService.read(id));
    }

    @PostMapping("")
    public void Post(@RequestBody Passenger passenger){
        passengerService.update(passenger);
    }

    @PutMapping("{id}")
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

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        passengerService.delete(id);
    }
}