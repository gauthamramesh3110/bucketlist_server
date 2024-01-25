package com.bucketlist.app.bucketlist.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="\"User\"")
public class User implements UserDetails {

    @Id 
    @GeneratedValue
    private Long id;
    private String email;
    private String passwordString;

    User(){}

    User(Long id, String email, String passwordString) {
        this.id = id;
        this.email = email;
        this.passwordString = passwordString;
    }

    public Long getId(){
        return this.id;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPasswordString(){
        return this.passwordString;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPasswordString(String password){
        this.passwordString = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.passwordString;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}