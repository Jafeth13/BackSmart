package com.SmartParking.Proyect.controller;

import com.SmartParking.Proyect.domain.Parking_Lot;
import com.SmartParking.Proyect.domain.Vehicle_Type;
import com.SmartParking.Proyect.service.ParkingService;
import com.SmartParking.Proyect.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/vehicleType")
public class VehicleTypeController {
    @Autowired
    private VehicleTypeService service;


    @GetMapping("/getAll")
    public List<Vehicle_Type> list() {
        return service.listAll();
    }

    @GetMapping("/getVehicleType/{id}")
    public ResponseEntity<Vehicle_Type> get(@PathVariable Integer id) {
        try {
            Vehicle_Type vehicle_type = service.get(id);
            return new ResponseEntity<Vehicle_Type>(vehicle_type, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Vehicle_Type>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Vehicle_Type vehicle_type) {
        service.save(vehicle_type);
    }
}
