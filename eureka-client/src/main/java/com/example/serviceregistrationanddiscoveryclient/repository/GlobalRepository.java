package com.example.serviceregistrationanddiscoveryclient.repository;

import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.Global;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface GlobalRepository  extends MongoRepository<Global, Integer> {
    List<Global> findAll();
}
