package com.SmartParking.Proyect.controller;

import com.SmartParking.Proyect.domain.Parking_Lot;
import com.SmartParking.Proyect.domain.User_Smart;
import com.SmartParking.Proyect.domain.Vehicle;
import com.SmartParking.Proyect.service.ParkingService;
import com.SmartParking.Proyect.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService service;

    @GetMapping("/getAll")

    public List<Vehicle> list() {
        return service.listAll();
    }

    @GetMapping("/getVehicle/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Vehicle> get(@PathVariable Integer id) {
        try {
            Vehicle vehicle = service.get(id);
            return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/update")
    @PreAuthorize("hasRole('Admin')")
    public void update(@RequestBody Vehicle vehicle){
        service.save(vehicle);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('Admin')")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('Admin')")
    public void add(@RequestBody Vehicle vehicle) {
        service.save(vehicle);
    }
}
