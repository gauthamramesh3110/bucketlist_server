package com.bucketlist.app.bucketlist.bucket;

import org.springframework.data.repository.Repository;
import java.util.List;


public interface BucketRepository extends Repository <Bucket, Long> {
    Bucket save(Bucket bucket);
    List<Bucket> findById(Long id);
    List<Bucket> findByOwnerId(Long ownerId);
    List<Bucket> findByBucketName(String bucketName);
}
