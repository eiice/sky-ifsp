package com.example.demo.controller;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.model.Flight;
import com.example.demo.service.FlightService;
import javax.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	FlightService flightService;
	@GetMapping("list")
	public ResponseEntity<List<Flight>> List()
	{
		return ResponseEntity.ok(flightService.list());
	}

	@GetMapping("{id}")
	public ResponseEntity<Flight>  Get(@Valid @PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(flightService.read(id));
	}

	@PostMapping("")
	public void Post(@RequestBody Flight flight){
		flightService.update(flight);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> Put(@Valid @RequestBody Flight flight, @PathVariable Integer id) {
		try {
			Flight existingFlight = flightService.read(id);
			flight.setId(id);
			flightService.update(flight);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id){
		flightService.delete(id);
	}
}