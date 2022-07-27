package com.SmartParking.Proyect.service;


import com.SmartParking.Proyect.domain.Parking_Lot;
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
    private EmailSenderService emailSenderService = new EmailSenderService();
    @Autowired
    private MessageSenderService messageSenderService;

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
        messageSenderService.sendMessage(user_smart.getTel_number(), "Bienvenido!! Mensaje de confirmacion de cuenta con SmartParking");
        emailSenderService.sendEmail(user_smart.getEmail(), "Correo de Bienvenida", "Bienvenido!! Mensaje de confirmacion de cuenta con SmartParking");
    }
    public User_Smart findByEmail(String email){ return  userRepository.findByEmail(email); }
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public List<User_Smart> clientList(String role) {return userRepository.findUser_SmartByRoleName(role);
    }
}
