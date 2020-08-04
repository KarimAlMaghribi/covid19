package com.example.serviceregistrationanddiscoveryclient.dto.mapper;

import com.example.serviceregistrationanddiscoveryclient.dto.model.CountryDTO;
import com.example.serviceregistrationanddiscoveryclient.model.entity.CountryEntity;
import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.Country;

public class CountryMapper {
    public static CountryDTO toCountryDTO(CountryEntity countryEntity) {
        return new CountryDTO()
                .setCountry(countryEntity.getCountry())
                .setCountryCode(countryEntity.getCountryCode())
                .setSlug(countryEntity.getSlug())
                .setNewConfirmed(countryEntity.getNewConfirmed())
                .setTotalConfirmed(countryEntity.getTotalConfirmed())
                .setNewDeaths(countryEntity.getNewDeaths())
                .setTotalDeaths(countryEntity.getTotalDeaths())
                .setNewRecovered(countryEntity.getNewRecovered())
                .setTotalRecovered(countryEntity.getTotalRecovered())
                .setDate(countryEntity.getDate());
    }

    public static CountryDTO toCountryDTO(Country countryEntity) {
        return new CountryDTO()
                .setCountry(countryEntity.getCountry())
                .setCountryCode(countryEntity.getCountryCode())
                .setSlug(countryEntity.getSlug())
                .setNewConfirmed(countryEntity.getNewConfirmed())
                .setTotalConfirmed(countryEntity.getTotalConfirmed())
                .setNewDeaths(countryEntity.getNewDeaths())
                .setTotalDeaths(countryEntity.getTotalDeaths())
                .setNewRecovered(countryEntity.getNewRecovered())
                .setTotalRecovered(countryEntity.getTotalRecovered())
                .setDate(countryEntity.getDate());
    }
}
