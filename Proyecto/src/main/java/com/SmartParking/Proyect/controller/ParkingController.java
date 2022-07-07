package com.SmartParking.Proyect.controller;


import com.SmartParking.Proyect.domain.ParkingLot;
import com.SmartParking.Proyect.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/parking")
public class ParkingController {

    @Autowired
    private ParkingService service;


    @GetMapping("/getAll")
    public List<ParkingLot> list() {
        return service.listAll();
    }

    @GetMapping("/getParking/{id}")
    public ResponseEntity<ParkingLot> get(@PathVariable Integer id) {
        try {
            ParkingLot parkingLot = service.get(id);
            return new ResponseEntity<ParkingLot>(parkingLot, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<ParkingLot>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);


    }
    @PostMapping("/add")
    public void add(ParkingLot parkingLot) {
        service.save(parkingLot);
    }


}
