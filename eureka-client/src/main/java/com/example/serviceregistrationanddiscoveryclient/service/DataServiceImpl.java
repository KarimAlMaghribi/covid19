package com.example.serviceregistrationanddiscoveryclient.service;

import com.example.serviceregistrationanddiscoveryclient.dto.mapper.CountryMapper;
import com.example.serviceregistrationanddiscoveryclient.dto.mapper.GlobalMapper;
import com.example.serviceregistrationanddiscoveryclient.dto.model.CountryDTO;
import com.example.serviceregistrationanddiscoveryclient.dto.model.GlobalDTO;
import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.Country;
import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.Global;
import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.InsertPojoToMongoTask;
import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.RetrieveDataTask;
import com.example.serviceregistrationanddiscoveryclient.repository.CountryRepository;
import com.example.serviceregistrationanddiscoveryclient.repository.GlobalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class DataServiceImpl implements DataService{

    @Autowired
    RetrieveDataTask apiTask = new RetrieveDataTask();
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private GlobalRepository globalRepository;

    @Override
    public List<CountryDTO> getAllCountries() {
        List<Country> countryList = countryRepository.findAll();
        List<CountryDTO> countryDTOS = new ArrayList<>();

        for(Country country: countryList) {
            countryDTOS.add(CountryMapper.toCountryDTO(country));
            System.out.println(country.getCountry());
        }

        return countryDTOS;
    }

    @Override
    public CountryDTO getCountryByName(String countryName) {
        List<Country> countryList = countryRepository.findAll();
        CountryDTO countryDTO = new CountryDTO();
        for (Country country: countryList) {
            if (country.getCountry() == countryName) {
                countryDTO =  CountryMapper.toCountryDTO(country);
            }
        }
        return countryDTO;
    }

    @Override
    public List<CountryDTO> getCountriesByLetter(String letter) {
        List<Country> countryList = countryRepository.findAll();
        List<CountryDTO> countryDTOList = new ArrayList<>();
        for (Country country: countryList) {
            if (country.getCountry().charAt(0) == letter.charAt(0)) {
                countryDTOList.add(CountryMapper.toCountryDTO(country));
            }
        }
        return countryDTOList;
    }

    @Override
    public void setAllCountries() {
        List<Country> countryList = apiTask.getCountryList();
        countryRepository.deleteAll();
        countryRepository.saveAll(countryList);
    }


    @Override
    public GlobalDTO getGlobalData() {
        return GlobalMapper.toGlobalDTO(globalRepository.findAll().get(0));
    }

    @Override
    public void setGlobalData() {
        Global globalData = apiTask.getGlobalData();
        globalRepository.deleteAll();
        globalRepository.save(globalData);
    }



    private void updateDB() {
        RetrieveDataTask apiTask = new RetrieveDataTask();
        InsertPojoToMongoTask mongoTask = new InsertPojoToMongoTask();

        List<Country> countryList = apiTask.getCountryList();
        Global globals = apiTask.getGlobalData();

        mongoTask.saveGlobal(globals);

        mongoTask.drobCountryCollection(countryList.get(0));
        for( Country country: countryList) {
            mongoTask.saveCountry(country);
        }
    }
}
