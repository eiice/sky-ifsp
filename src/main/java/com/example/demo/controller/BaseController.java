package com.example.demo.controller;

import com.example.demo.model.BaseEntity;
import com.example.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;


public class BaseController <Service extends BaseService<JpaRepository<Model, Integer>, Model>, Model extends BaseEntity> {

    @Autowired
    Service baseService;

    @GetMapping("/list")
    public ResponseEntity<List<?>> list()
    {
        return ResponseEntity.ok(baseService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Model>  get(@Valid @PathVariable("id") Integer id)
    {
        return ResponseEntity.ok(baseService.read(id));
    }

    @PostMapping("")
    public void post(@RequestBody Model model){
        baseService.createOrUpdate(model);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@Valid @RequestBody Model model, @PathVariable Integer id) {
            try {
                BaseEntity existingModel = baseService.read(id);
                model.setId(id);
                baseService.createOrUpdate(model);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (NoSuchElementException e) {
                baseService.createOrUpdate(model);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        baseService.delete(id);
    }
}
