package com.SmartParking.Proyect.controller;


import com.SmartParking.Proyect.domain.Spot;
import com.SmartParking.Proyect.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/spot")
public class SpotController {

    @Autowired
    private SpotService service;


    @GetMapping("/getAll")
    public List<Spot> list() {
        return service.listAll();
    }

    @GetMapping("/getSpot/{id}")
    public ResponseEntity<Spot> get(@PathVariable Integer id) {
        try {
            Spot spot = service.get(id);
            return new ResponseEntity<Spot>(spot, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Spot>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);


    }
    @PostMapping("/add")
    public void add(@RequestBody Spot spot) {
        service.save(spot);
    }


}

