package com.SmartParking.Proyect.service;


import com.SmartParking.Proyect.domain.User_Smart;
import com.SmartParking.Proyect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User_Smart> listAllUser() {return userRepository.findAll();}

    public User_Smart get(int id) {
        return userRepository.findById(id).get();
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public void save(User_Smart parkingLot) {
        userRepository.save(parkingLot);
    }
}
