package com.SmartParking.Proyect.controller;


import com.SmartParking.Proyect.domain.Parking_Lot;
import com.SmartParking.Proyect.domain.Parking_Lot;
import com.SmartParking.Proyect.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/parking")
public class ParkingController {

    @Autowired
    private ParkingService service;


    @GetMapping("/getAll")
    @PreAuthorize("hasRole('Admin')")
    public List<Parking_Lot> list() {
        return service.listAll();
    }

    @GetMapping("/getProv/{province}")
    @PreAuthorize("hasRole('Client')")
    public List<Parking_Lot> listProvince(@PathVariable String province) {
        
        return service.listProvince(province);

    }

    @GetMapping("/getParking/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Parking_Lot> get(@PathVariable Integer id) {
        try {
            Parking_Lot parkingLot = service.get(id);
            return new ResponseEntity<Parking_Lot>(parkingLot, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Parking_Lot>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('Admin')")
    public void delete(@PathVariable Integer id) {
        service.delete(id);


    }
    @PostMapping("/add")
    @PreAuthorize("hasRole('Admin')")
    public void add(@RequestBody Parking_Lot parkingLot) {
        service.save(parkingLot);
    }

    @PutMapping(value = "/update")
    @PreAuthorize("hasRole('Admin')")
    public void update(@RequestBody Parking_Lot parkingLot){
        
        service.save(parkingLot);
    }


}
