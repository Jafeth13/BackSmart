package com.SmartParking.Proyect.controller;


import com.SmartParking.Proyect.domain.Spot;
import com.SmartParking.Proyect.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/spot")
public class SpotController {

    @Autowired
    private SpotService service;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAll")
    @PreAuthorize("hasRole('Admin')")
    public List<Spot> list() {
        return service.listAll();
    }

    @GetMapping("/getSpot/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Spot> get(@PathVariable Integer id) {
        try {
            Spot spot = service.get(id);
            return new ResponseEntity<Spot>(spot, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Spot>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getSpots/{id}")
    @PreAuthorize("hasRole('Client')")
    public List<Spot> listSpot(@PathVariable int id) {

        return service.listSpot(id);

    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('Admin')")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
    @PostMapping("/add")
    @PreAuthorize("hasRole('Admin')")
    public void add(@RequestBody Spot spot) {
        service.save(spot);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('Admin')")
    public void update(@RequestBody Spot spot) {
        service.save(spot);
    }
}

