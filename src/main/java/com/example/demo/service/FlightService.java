package com.example.demo.service;

import com.example.demo.model.Airplane;
import com.example.demo.model.Flight;
import com.example.demo.repository.AirplaneRepository;
import com.example.demo.repository.FlightRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;
    public List<Flight> list() {
        return flightRepository.findAll();
    }

    public void update(Flight flight) {
        flightRepository.save(flight);
    }

    public Flight read(Integer id) {
        return flightRepository.findById(id).get();
    }

    public void delete(Integer id) {
        flightRepository.deleteById(id);
    }

    public double calculateDistance(Flight flight){
        double destinationLatitude = flight.getDestination().getLatitude();
        double originLatitude = flight.getOrigin().getLatitude();
        double destinationLongitude = flight.getDestination().getLongitude();
        double originLongitude = flight.getOrigin().getLongitude();

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(originLatitude - destinationLatitude);
        double lonDistance = Math.toRadians(originLongitude - destinationLongitude);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(destinationLatitude)) * Math.cos(Math.toRadians(originLatitude))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = Math.ceil((R * c) / 1000); // convert to meters

        return distance;
    }
}
