package com.example.demo.controller;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.model.Airplane;
import com.example.demo.service.AirplaneService;
import javax.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airplane")
@Validated
public class AirplaneController {
	@Autowired
	AirplaneService airplaneService;
	@GetMapping("/list")
	public ResponseEntity<List<Airplane>> List()
	{
		return ResponseEntity.ok(airplaneService.list());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Airplane>  Get(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(airplaneService.read(id));
	}

	@PostMapping("")
	public void Post(@Valid @RequestBody Airplane airplane){
		airplaneService.update(airplane);
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
