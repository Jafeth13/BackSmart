package com.SmartParking.Proyect.controller;


import com.SmartParking.Proyect.domain.Parking_Lot;
import com.SmartParking.Proyect.domain.User_Smart;
import com.SmartParking.Proyect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    @PreAuthorize("hasRole('Admin')")
    public List<User_Smart> list() {
        return userService.listAllUser();
    }

    @GetMapping("/getUser/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<User_Smart> get(@PathVariable Integer id) {
        try {
            User_Smart user = userService.get(id);
            return new ResponseEntity<User_Smart>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User_Smart>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addUser")
    @PreAuthorize("hasRole('Admin')")
    public void add(@RequestBody User_Smart user) {
        userService.save(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    @PreAuthorize("hasRole('Admin')")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }

    @PutMapping(value = "/update")
    @PreAuthorize("hasRole('Admin')")
    public void update(@RequestBody User_Smart user_smart){
        userService.save(user_smart);
    }

}
