package com.SmartParking.Proyect.repository;

import com.SmartParking.Proyect.domain.User_Smart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User_Smart, Integer> {

    User_Smart findByEmail(String email);
}
