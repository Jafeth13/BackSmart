package com.SmartParking.Proyect.controller;


import com.SmartParking.Proyect.domain.RateType;
import com.SmartParking.Proyect.service.RateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<RateType> list() {
        return rateTypeService.listAll();
    }

    @GetMapping("/getRateType/{id}")
    public ResponseEntity<RateType> get(@PathVariable Integer id) {
        try {
            RateType rateType = rateTypeService.get(id);
            return new ResponseEntity<RateType>(rateType, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<RateType>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public void add(@RequestBody RateType rateType){
        rateTypeService.save(rateType);
    }

    @PutMapping("/update")
    public ResponseEntity<RateType> update(@RequestBody RateType rateType) {
        try {
            rateTypeService.save(rateType);
            return new ResponseEntity<RateType>(rateType, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<RateType>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        rateTypeService.delete(id);
    }

}
