package com.example.demo.service;

import com.example.demo.model.Airplane;
import com.example.demo.model.Passenger;
import com.example.demo.repository.AirplaneRepository;
import com.example.demo.repository.PassengerRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;
    public List<Passenger> list() {
        return passengerRepository.findAll();
    }

    public void update(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    public Passenger read(Integer id) {
        return passengerRepository.findById(id).get();
    }

    public void delete(Integer id) {
        passengerRepository.deleteById(id);
    }
}
