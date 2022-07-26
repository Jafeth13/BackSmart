package com.SmartParking.Proyect.controller;

import com.SmartParking.Proyect.domain.Ticket;
import com.SmartParking.Proyect.domain.Vehicle;
import com.SmartParking.Proyect.service.TicketService;
import com.SmartParking.Proyect.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/Tickets")
public class TicketController {

        @Autowired
        private TicketService service;

        @GetMapping("/getAll")
        public List<Ticket> list() {
            return service.listAll();
        }

        @GetMapping("/getTicket/{id}")
        public ResponseEntity<Ticket> get(@PathVariable Integer id) {
            try {
                Ticket ticket = service.get(id);
                return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
            } catch (NoSuchElementException e) {
                return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
            }
        }

        @PutMapping(value = "/update")
        public void update(@RequestBody Ticket ticket){
            service.save(ticket);
        }

        @DeleteMapping("/delete/{id}")
        public void delete(@PathVariable Integer id) {
            service.delete(id);
        }

        @PostMapping("/add")
        public void add(@RequestBody Ticket ticket) {
            service.save(ticket);
        }
}
