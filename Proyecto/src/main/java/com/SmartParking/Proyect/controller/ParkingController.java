package com.SmartParking.Proyect.controller;


import com.SmartParking.Proyect.domain.Parking_Lot;
import com.SmartParking.Proyect.domain.Parking_Lot;
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
    public List<Parking_Lot> list() {
        return service.listAll();
    }

    @GetMapping("/getParking/{id}")
    public ResponseEntity<Parking_Lot> get(@PathVariable Integer id) {
        try {
            Parking_Lot parkingLot = service.get(id);
            return new ResponseEntity<Parking_Lot>(parkingLot, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Parking_Lot>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);


    }
    @PostMapping("/add/")
    public void add(Parking_Lot parkingLot) {
        service.save(parkingLot);
    }


}
