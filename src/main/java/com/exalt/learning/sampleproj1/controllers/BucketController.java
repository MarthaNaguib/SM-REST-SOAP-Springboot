package com.exalt.learning.sampleproj1.controllers;

import com.exalt.learning.sampleproj1.Objects.Bucket;
import com.exalt.learning.sampleproj1.Services.BucketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import simplesolution.dev.GetAllBucketsResponse;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class BucketController {

    BucketService bucketService;
    @GetMapping("/buckets")
    public GetAllBucketsResponse readBucketById() {
        return bucketService.getAllBuckets();
    }
    @GetMapping("/buckets/{id}")
    public Optional<Bucket> readBucketById(@PathVariable("id") Integer id) {
        return bucketService.readBucketById(id);
    }    @PostMapping("/buckets")
    public void addBucket(@RequestBody Bucket bucket) {
        bucketService.addBucket(bucket);
    }
    @PutMapping("/buckets/{id}")
    public void updateBucket(@RequestBody Bucket bucket){
        bucketService.updateBucket(bucket);
    }
    @DeleteMapping("/buckets/{id}")
    public void deleteBucketById(@PathVariable("id") Integer id) {
        bucketService.removeBucketById(id);
    }
}
