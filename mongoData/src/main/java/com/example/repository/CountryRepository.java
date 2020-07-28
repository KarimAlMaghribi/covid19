package com.example.repository;

@Repository
public interface CountryCrudRepository
        extends ReactiveCrudRepository<CountryEntity, String> {
    Mono<CountryEntity> findCountryByName(Mono<String> name);
}
