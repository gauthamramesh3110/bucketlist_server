package com.codedbygautham.bucketlist.bucket;

import org.springframework.web.bind.annotation.RestController;

import com.codedbygautham.bucketlist.user.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@RestController
public class BucketController {
    @Autowired
    BucketRepository repository;

    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping("bucket")
    public Bucket createBucket(@RequestBody Bucket bucket) {
        User u = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        bucket.setOwnerId(u.getId());
        repository.save(bucket);
        return bucket;
    }

    @GetMapping("bucket/all")
    public List<Bucket> getAllBucketsByOwner() {
        User u = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return repository.findByOwnerId(u.getId());
    }

    @GetMapping("bucket")
    public Bucket getBucketById(@RequestParam Long bucketId) {
        User u = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Bucket b = repository.findById(bucketId).get(0);

        if(b.getOwnerId().equals(u.getId())) return b;
        return null;
    }

    @DeleteMapping("bucket")
    public void deleteBucketById(@RequestParam Long id) {
        repository.deleteById(id);
    }
    
}
