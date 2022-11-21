package com.exalt.learning.sampleproj1.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@Document(collection = "SMtable")
@AllArgsConstructor
public class Bucket {
    @Id
    private int id;
    private String type;
    private int capacity;
}