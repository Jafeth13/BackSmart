package com.SmartParking.Proyect.service;

import com.SmartParking.Proyect.domain.Ticket;
import com.SmartParking.Proyect.domain.Vehicle;
import com.SmartParking.Proyect.repository.TicketRepository;
import com.SmartParking.Proyect.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TicketService {
    @Autowired
    private TicketRepository repository;

    public List<Ticket> listAll() {return repository.findAll();
    }

    public void save(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
