package com.SmartParking.Proyect.repository;

import com.SmartParking.Proyect.domain.Parking_Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking_Lot, Integer> {
}
