package com.codedbygautham.bucketlist.bucketItem;

import org.springframework.data.repository.Repository;
import java.util.List;


public interface BucketItemRepository extends Repository<BucketItem, Long> {
    BucketItem save(BucketItem bucketItem);
    List<BucketItem> findByBucketId(Long bucketId);
}
