package com.SmartParking.Proyect.service;

import com.SmartParking.Proyect.domain.Vehicle_Type;
import com.SmartParking.Proyect.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VehicleTypeService {
    @Autowired
    private VehicleTypeRepository repository;

    public List<Vehicle_Type> listAll() {return repository.findAll();
    }

    public void save(Vehicle_Type type) {
        repository.save(type);
    }

    public Vehicle_Type get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
