package com.example.demo.service;

import com.example.demo.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Getter
@Setter
public class BaseService <Repository extends JpaRepository<Model, Integer>, Model extends BaseEntity>{

    public Repository repository;

    public List<?> list() {
        return repository.findAll();
    }

    public void createOrUpdate(Model model) {
        repository.save(model);
    }

    public Model read(Integer id) {
        return repository.findById(id).get();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}