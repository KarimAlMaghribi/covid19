package com.example.serviceregistrationanddiscoveryclient.service;

import com.example.serviceregistrationanddiscoveryclient.dto.model.CountryDTO;
import com.example.serviceregistrationanddiscoveryclient.dto.model.GlobalDTO;

import java.util.List;

public interface DataService {
    List<CountryDTO> getAllCountries();
    CountryDTO getCountryByName(CountryDTO countryDTO);
    List<CountryDTO> getCountriesByLetter(String letter);
    GlobalDTO getGlobalData();
}
