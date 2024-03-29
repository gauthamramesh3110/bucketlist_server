package com.codedbygautham.bucketlist.bucket;

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
public class Bucket {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    String bucketName;

    private Long ownerId;
}
