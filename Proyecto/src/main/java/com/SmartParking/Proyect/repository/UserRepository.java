package com.SmartParking.Proyect.repository;

import com.SmartParking.Proyect.domain.User_Smart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User_Smart, Integer> {
    User_Smart findByEmail(String email);

    @Query(value="SELECT u FROM User_Smart u WHERE u.role.name = :Role")
    List<User_Smart> findUser_SmartByRoleName(@Param("Role")String role);
}
