package com.SmartParking.Proyect.controller;


import com.SmartParking.Proyect.domain.RateType;
import com.SmartParking.Proyect.service.RateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/rateType")
public class RateTypeController {

    @Autowired
    private RateTypeService rateTypeService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllRateTypes")
    @PreAuthorize("hasRole('Admin')")
    public List<RateType> list() {
        return rateTypeService.listAll();
    }

    @GetMapping("/getRateType/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<RateType> get(@PathVariable Integer id) {
        try {
            RateType rateType = rateTypeService.get(id);
            return new ResponseEntity<RateType>(rateType, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<RateType>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('Admin')")
    public void add(@RequestBody RateType rateType){
        rateTypeService.save(rateType);
    }

    @PutMapping(value = "/update")
    @PreAuthorize("hasRole('Admin')")
    public void update(@RequestBody RateType rateType){
        rateTypeService.save(rateType);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('Admin')")
    public void delete(@PathVariable Integer id) {
        rateTypeService.delete(id);
    }

}
