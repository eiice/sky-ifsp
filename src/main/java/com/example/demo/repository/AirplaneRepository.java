package com.example.demo.repository;

import com.example.demo.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {
}
