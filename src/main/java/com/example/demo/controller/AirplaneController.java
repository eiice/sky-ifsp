package com.example.demo.controller;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.model.Airplane;
import com.example.demo.model.dto.AirplaneDto;
import com.example.demo.service.AirplaneService;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airplane")
@Validated
public class AirplaneController {
	AirplaneService airplaneService;
	private ModelMapper modelMapper;

	public AirplaneController(AirplaneService airplaneService, ModelMapper modelMapper) {
		this.airplaneService = airplaneService;
		this.modelMapper = modelMapper;
	}

	@GetMapping("/list")
	public ResponseEntity<List<AirplaneDto>> List()
	{
		List<Airplane> airplanes = airplaneService.list();
		List<AirplaneDto> airplaneDtos = modelMapper.map(airplanes, new TypeToken<List<AirplaneDto>>() {}.getType());
		return ResponseEntity.ok(airplaneDtos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>  Get(@PathVariable("id") Integer id)
	{
		try {
			Airplane airplane = airplaneService.read(id);
			AirplaneDto airplaneDto = modelMapper.map(airplane, AirplaneDto.class);
			return ResponseEntity.ok(airplaneDto);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("")
	public ResponseEntity<?>  Post(@Valid @RequestBody Airplane airplane){
		airplaneService.update(airplane);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> Put(@Valid @RequestBody Airplane airplane, @PathVariable Integer id) {
		try {
			Airplane existingAirplane = airplaneService.read(id);
			airplane.setId(id);
			airplaneService.update(airplane);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id){
		airplaneService.delete(id);
	}
}
