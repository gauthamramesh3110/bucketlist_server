package com.codedbygautham.bucketlist.bucket;

import org.springframework.data.repository.Repository;
import java.util.List;


public interface BucketRepository extends Repository <Bucket, Long> {
    Bucket save(Bucket bucket);
    void deleteById(Long id);
    List<Bucket> findById(Long id);
    List<Bucket> findByOwnerId(Long ownerId);
    List<Bucket> findByBucketName(String bucketName);
}
