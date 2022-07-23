package com.SmartParking.Proyect.service;


import com.SmartParking.Proyect.domain.User_Smart;
import com.SmartParking.Proyect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User_Smart> listAllUser() {return userRepository.findAll();}

    public User_Smart get(int id) {
        return userRepository.findById(id).get();
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public void save(User_Smart user_smart) {
        user_smart.setPassword(getEncodedPassword(user_smart.getPassword()));
        userRepository.save(user_smart);
    }

    public User_Smart findByEmail(String email){ return  userRepository.findByEmail(email); }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
