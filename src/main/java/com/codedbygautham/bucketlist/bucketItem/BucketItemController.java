package com.codedbygautham.bucketlist.bucketItem;

import org.springframework.web.bind.annotation.RestController;

import com.codedbygautham.bucketlist.bucket.BucketRepository;
import com.codedbygautham.bucketlist.user.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class BucketItemController {
    @Autowired
    BucketItemRepository repository;

    @Autowired
    UserDetailsService userDetailsService;
    
    @PostMapping("bucketItem")
    public BucketItem createBucketItem(@RequestBody BucketItem bucketItem) {
        return repository.save(bucketItem);
    }
    
    @GetMapping("bucketItem")
    public List<BucketItem> getMethodName(@RequestParam String bucketId) {
        return repository.findByBucketId(Long.parseLong(bucketId));
    }
    
}
