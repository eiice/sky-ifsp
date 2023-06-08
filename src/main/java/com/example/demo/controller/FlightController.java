package com.example.demo.controller;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.model.Flight;
import com.example.demo.model.dto.FlightDto;
import com.example.demo.service.FlightService;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight")
@Validated
public class FlightController {
	FlightService flightService;
	private ModelMapper modelMapper;

	public FlightController(FlightService flightService, ModelMapper modelMapper) {
		this.flightService = flightService;
		this.modelMapper = modelMapper;
	}

	@GetMapping("/list")
	public ResponseEntity<List<FlightDto>> List()
	{
		List<Flight> flights = flightService.list();
		List<FlightDto> flightDtos = modelMapper.map(flights, new TypeToken<List<FlightDto>>() {}.getType());
		return ResponseEntity.ok(flightDtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?>  Get(@PathVariable("id") Integer id)
	{
		try {
			Flight flight = flightService.read(id);
			FlightDto flightDto = modelMapper.map(flight, FlightDto.class);
			return ResponseEntity.ok(flightDto);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("")
	public ResponseEntity<?>  Post(@Valid @RequestBody Flight flight){
		flightService.update(flight);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
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

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id){
		flightService.delete(id);
	}
}