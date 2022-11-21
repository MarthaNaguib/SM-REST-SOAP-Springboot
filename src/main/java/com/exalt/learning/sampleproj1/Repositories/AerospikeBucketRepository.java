package com.exalt.learning.sampleproj1.Repositories;
import com.exalt.learning.sampleproj1.Objects.Bucket;
import org.springframework.data.aerospike.repository.AerospikeRepository;

public interface AerospikeBucketRepository extends AerospikeRepository<Bucket, Integer> {
}
