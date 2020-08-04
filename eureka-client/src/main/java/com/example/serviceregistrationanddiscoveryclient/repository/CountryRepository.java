package com.example.serviceregistrationanddiscoveryclient.repository;

import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CountryRepository extends MongoRepository<Country, String> {
    Country findByCountry (String country);
    Country findByCountryCode (String countryCode);
    List<Country> findAll();
}