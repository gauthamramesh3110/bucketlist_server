package com.bucketlist.app.bucketlist.repositories;

import org.springframework.data.repository.Repository;

import com.bucketlist.app.bucketlist.models.User;
import java.util.List;


public interface UserRepository extends Repository<User, Long> {
    User save(User user);
    List<User> findByEmail(String email);
    List<User> findById(Long id);
}
