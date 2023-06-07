package com.example.demo.service;

import com.example.demo.model.Airplane;
import com.example.demo.model.Airport;
import com.example.demo.repository.AirplaneRepository;
import com.example.demo.repository.AirportRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;
    public List<Airport> list() {
        return airportRepository.findAll();
    }

    public void update(Airport airport) {
        airportRepository.save(airport);
    }

    public Airport read(Integer id) {
        return airportRepository.findById(id).get();
    }

    public void delete(Integer id) {
        airportRepository.deleteById(id);
    }
}
