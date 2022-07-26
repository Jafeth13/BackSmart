package com.SmartParking.Proyect.repository;

import com.SmartParking.Proyect.domain.Spot;
import com.SmartParking.Proyect.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {



}
