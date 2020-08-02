package com.example.covidservice.repository;

import java.util.List;
import java.util.Optional;

import com.example.covidservice.model.entity.CountryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface CountryRepository extends MongoRepository<CountryEntity, String> {
    CountryEntity findByCountry (@Param("country") String country);
    CountryEntity findByCountryCode (@Param("countryCode") String countryCode);
    List<CountryEntity> findAll();
}