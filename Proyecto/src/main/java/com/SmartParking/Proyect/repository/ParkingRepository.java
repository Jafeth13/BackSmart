package com.SmartParking.Proyect.repository;

import com.SmartParking.Proyect.domain.Parking_Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<Parking_Lot, Integer> {

    @Query(value="SELECT u FROM Parking_Lot u WHERE u.province = :Prov")
    List<Parking_Lot> findParking_LotByProvince(@Param("Prov")String province);

}
