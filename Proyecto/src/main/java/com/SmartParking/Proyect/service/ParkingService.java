package com.SmartParking.Proyect.service;


import com.SmartParking.Proyect.domain.ParkingLot;
import com.SmartParking.Proyect.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ParkingService {

    @Autowired
    private ParkingRepository repository;

    public List<ParkingLot> listAll() {return repository.findAll();
    }

    public void save(ParkingLot parkingLot) {
        repository.save(parkingLot);
    }

    public ParkingLot get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
