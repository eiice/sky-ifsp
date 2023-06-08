package com.example.demo.service;

import com.example.demo.model.Airplane;
import com.example.demo.model.Flight;
import com.example.demo.repository.AirplaneRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AirplaneService {
    @Autowired
    private AirplaneRepository airplaneRepository;
    public List<Airplane> list() {
        List<Airplane> airplanes = airplaneRepository.findAll();
        return airplanes;
    }

    public void update(Airplane airplane) {
        airplaneRepository.save(airplane);
    }

    public Airplane read(Integer id) {
        return airplaneRepository.findById(id).get();
    }

    public void delete(Integer id) {
        airplaneRepository.deleteById(id);
    }
}
