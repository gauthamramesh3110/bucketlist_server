package com.codedbygautham.bucketlist.bucketItem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class BucketItem {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    Long bucketId;
    
    @Column(nullable = false)
    String locationId;
    
    @Column(nullable = false)
    String displayName;
    
    @Column(nullable = false)
    Long latitude;
    
    @Column(nullable = false)
    Long longitude;
}
