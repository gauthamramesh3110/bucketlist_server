package com.bucketlist.app.bucketlist;

import java.util.Optional;

import org.springframework.data.repository.Repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="\"User\"")
public class User {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

    User(){}

    User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.username = username;
    }

    public Long getId(){
        return this.id;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }

}

interface UserRepository extends Repository<User, Long> {
    User save(User user);
    Optional<User> findByUsername(String username);
}