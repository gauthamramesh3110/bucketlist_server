package com.bucketlist.app.bucketlist;

import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping("hello")
    public String sayHello() {
        return "Hello";
    }
    

    @PostMapping("user")
    public String createNewUser(@RequestBody User user) {     
        repository.save(user); 
        Optional<User> currentUser = repository.findByUsername(user.getUsername());
        String token = JWT.create()
        .withSubject(currentUser.get().getId().toString())
        .withExpiresAt(new Date(System.currentTimeMillis() + 900_000))
        .sign(Algorithm.HMAC256("alert123"));
        return token;
    }
}
