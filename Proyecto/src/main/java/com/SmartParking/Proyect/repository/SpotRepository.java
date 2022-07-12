package com.SmartParking.Proyect.repository;

import com.SmartParking.Proyect.domain.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotRepository extends JpaRepository<Spot, Integer> {
}
