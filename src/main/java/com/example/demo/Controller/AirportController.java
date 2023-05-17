package com.example.demo.Controller;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airport")
public class AirportController {
	@GetMapping("/list")
	public List<Object> List(@RequestParam String name,
								@RequestParam String country,
								@RequestParam Double latitude,
								@RequestParam Double longitude,
								@RequestParam String name) 
	{
		//
	}
	
	@GetMapping("/get")
	public List<Object> Get(@RequestParam int id) 
	{
		//
	}
}
