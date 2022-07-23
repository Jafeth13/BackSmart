package com.SmartParking.Proyect.repository;

import com.SmartParking.Proyect.domain.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpotRepository extends JpaRepository<Spot, Integer> {


    @Query(value="SELECT u FROM Spot u WHERE u.parking_lot.id_Parking_Lot = :id")
    List<Spot> findSpotsByParking_Lot(@Param("id")int id_parking);

}
