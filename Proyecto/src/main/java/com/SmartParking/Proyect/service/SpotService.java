package com.SmartParking.Proyect.service;

import com.SmartParking.Proyect.domain.Spot;
import com.SmartParking.Proyect.repository.SpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class SpotService {

    @Autowired
    private SpotRepository repository;

    public List<Spot> listAll() {return repository.findAll();
    }

    public void save(Spot spot) {
        repository.save(spot);
    }

    public Spot get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<Spot> listSpot(int id_parking) {return repository.findSpotsByParking_Lot(id_parking);
    }
}
