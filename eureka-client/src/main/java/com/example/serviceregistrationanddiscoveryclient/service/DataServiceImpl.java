package com.example.serviceregistrationanddiscoveryclient.service;

import com.example.serviceregistrationanddiscoveryclient.dto.mapper.CountryMapper;
import com.example.serviceregistrationanddiscoveryclient.dto.model.CountryDTO;
import com.example.serviceregistrationanddiscoveryclient.dto.model.GlobalDTO;
import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.Country;
import com.example.serviceregistrationanddiscoveryclient.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DataServiceImpl implements DataService{

    @Autowired
    private CountryRepository countryRepository;
    @Override
    public List<CountryDTO> getAllCountries() {
        List<Country> countryList = countryRepository.findAll();
        List<CountryDTO> countryDTOS = null;

        for(Country country: countryList) {
            countryDTOS.add(CountryMapper.toCountryDTO(country));
        }

        return countryDTOS;
    }

    @Override
    public CountryDTO getCountryByName(CountryDTO countryDTO) {
        return null;
    }

    @Override
    public List<CountryDTO> getCountriesByLetter(String letter) {
        return null;
    }

    @Override
    public GlobalDTO getGlobalData() {
        return null;
    }
}
