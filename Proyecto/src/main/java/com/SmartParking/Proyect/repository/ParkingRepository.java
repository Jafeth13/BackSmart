package com.SmartParking.Proyect.repository;

import com.SmartParking.Proyect.domain.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<ParkingLot, Integer> {
}
