package com.SmartParking.Proyect.service;


import com.SmartParking.Proyect.domain.Parking_Lot;
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

    public List<Parking_Lot> listAll() {return repository.findAll();
    }

    public void save(Parking_Lot parkingLot) {
        repository.save(parkingLot);
    }

    public Parking_Lot get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<Parking_Lot> listProvince(String province) {return repository.findParking_LotByProvince(province);
    }
}
