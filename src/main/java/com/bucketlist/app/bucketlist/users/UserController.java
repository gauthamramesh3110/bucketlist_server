package com.bucketlist.app.bucketlist.users;

import org.springframework.web.bind.annotation.RestController;

import com.bucketlist.app.bucketlist.services.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("hello")
    public String getMethodName() {
        return "Hello";
    }
    

    @PostMapping("user/create")
    public String createNewUser(@RequestBody User u) {
        u.setPasswordString(encoder.encode(u.getPasswordString()));
        repository.save(u); 
        User currentUser = repository.findByEmail(u.getEmail()).get(0);
        return JwtService.getUserToken(currentUser);
    }

    @PostMapping("user/login")
    public String loginUser(@RequestBody User u) {
        User currentUser = repository.findByEmail(u.getEmail()).get(0);
        if(currentUser.getPasswordString().equals(u.getPasswordString())) {
            return JwtService.getUserToken(currentUser);
        }
        return "User not found";
    }
    
}
