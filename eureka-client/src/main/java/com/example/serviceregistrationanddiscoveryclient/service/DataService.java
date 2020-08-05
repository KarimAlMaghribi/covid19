package com.example.serviceregistrationanddiscoveryclient.service;

import com.example.serviceregistrationanddiscoveryclient.dto.model.CountryDTO;
import com.example.serviceregistrationanddiscoveryclient.dto.model.GlobalDTO;
import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.Country;
import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.Global;
import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.InsertPojoToMongoTask;
import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.RetrieveDataTask;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DataService {
    List<CountryDTO> getAllCountries();
    CountryDTO getCountryByName(String countryName);
    List<CountryDTO> getCountriesByLetter(String letter);
    void setAllCountries();
    GlobalDTO getGlobalData();
    void setGlobalData();


}
