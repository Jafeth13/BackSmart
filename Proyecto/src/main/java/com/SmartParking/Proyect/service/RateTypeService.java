package com.SmartParking.Proyect.service;


import com.SmartParking.Proyect.domain.RateType;
import com.SmartParking.Proyect.repository.RateTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RateTypeService {

    @Autowired
    private RateTypeRepository rateTypeRepository;

    public List<RateType> listAll() {return rateTypeRepository.findAll();}

    public void save(RateType rateType) {
        rateTypeRepository.save(rateType);
    }

    public RateType get(int id) {
        return rateTypeRepository.findById(id).get();
    }

    public void delete(int id) {
        rateTypeRepository.deleteById(id);
    }
}
