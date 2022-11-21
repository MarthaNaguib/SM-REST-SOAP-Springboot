package com.exalt.learning.sampleproj1.Services;

import com.exalt.learning.sampleproj1.Objects.Bucket;
import com.exalt.learning.sampleproj1.Repositories.AerospikeBucketRepository;
import com.exalt.learning.sampleproj1.SOAPconnection;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simplesolution.dev.*;

import java.util.Optional;
@Service
@AllArgsConstructor
public class BucketService {
    AerospikeBucketRepository aerospikeBucketRepository;

    @Autowired
    SOAPconnection soaPconnection;
    public Optional<Bucket> readBucketById(int id) {
    return aerospikeBucketRepository.findById(id);
}
    public GetAllBucketsResponse getAllBuckets() {
        GetAllBucketsRequest request = new GetAllBucketsRequest();
        GetAllBucketsResponse response = (GetAllBucketsResponse)  soaPconnection.callWebService("http://localhost:8080/soapws/buckets.wsdl", request);
        return response;
    }

    public void addBucket(Bucket bucket) {
        aerospikeBucketRepository.save(bucket);
    AddBucketRequest request = new AddBucketRequest();
    request.setId(bucket.getId());
    request.setType(bucket.getType());
    request.setCapacity(bucket.getCapacity());
    AddBucketResponse response =(AddBucketResponse) soaPconnection.callWebService("http://localhost:8080/soapws/buckets.wsdl", request);

}
    public UpdateBucketResponse updateBucket(Bucket bucket) {
        UpdateBucketRequest request = new UpdateBucketRequest();
        BucketInfo bucketInfo=new BucketInfo();
        BeanUtils.copyProperties( bucket,bucketInfo);
        request.setBucketInfo(bucketInfo);
        UpdateBucketResponse response = (UpdateBucketResponse) soaPconnection.callWebService("http://localhost:8080/soapws/buckets.wsdl", request);
        aerospikeBucketRepository.save(bucket);
        return response;
    }
    public void removeBucketById(int id) {
        DeleteBucketRequest request = new DeleteBucketRequest();
        request.setId(id);
        DeleteBucketResponse response = (DeleteBucketResponse) soaPconnection.callWebService("http://localhost:8080/soapws/buckets.wsdl", request);
        aerospikeBucketRepository.deleteById(id);

}
}
