package com.bucketlist.app.bucketlist.services;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bucketlist.app.bucketlist.users.User;

public class JwtService {
    public static String getUserToken(User u){
        String token = JWT
            .create()
            .withSubject(u.getEmail())
            .withExpiresAt(new Date(System.currentTimeMillis() + 900_000))
            .sign(Algorithm.HMAC256("alert123"));
        return token;
    }

    public static String getUserFromToken(String token){
        return JWT.require(Algorithm.HMAC256("alert123")).build().verify(token).getSubject();
    }
}