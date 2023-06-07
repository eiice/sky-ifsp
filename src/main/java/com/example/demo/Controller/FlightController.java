package com.example.demo.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Dto.AirplaneDTO;
import com.example.demo.Model.Dto.AirportDTO;
import com.example.demo.Model.Dto.FlightDTO;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/flight")
public class FlightController {

	// @GetMapping("/list")
	// public List<List<Object>> List(@RequestParam int outward,
	// 							@RequestParam int outbound,
	// 							@RequestParam String departureTime,
	// 							@RequestParam String arrivalTime,
	// 							@RequestParam int airplane) 
	// {
	// 	//
	// }

	@ResponseBody
	@GetMapping()
	public FlightDTO Get(@RequestParam(value = "id", required = false) int id) 
	{
        FlightDTO flightRet = new FlightDTO();
		return flightRet;
	}
}