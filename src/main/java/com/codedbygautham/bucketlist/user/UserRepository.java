package com.codedbygautham.bucketlist.user;

import org.springframework.data.repository.Repository;

import java.util.List;


public interface UserRepository extends Repository<User, Long> {
    User save(User user);
    List<User> findByEmail(String email);
    List<User> findById(Long id);
}
