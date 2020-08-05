package com.example.serviceregistrationanddiscoveryclient.controller.v1.api;

import com.example.serviceregistrationanddiscoveryclient.model.entity.FavoriteCountryEntity;
import com.example.serviceregistrationanddiscoveryclient.model.entity.FavoriteGlobalEntity;
import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.Country;
import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.Global;
import com.example.serviceregistrationanddiscoveryclient.repository.CountryRepository;
import com.example.serviceregistrationanddiscoveryclient.repository.FavoritesCountryRepository;
import com.example.serviceregistrationanddiscoveryclient.repository.FavoritesGlobalRepository;
import com.example.serviceregistrationanddiscoveryclient.repository.GlobalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    CountryRepository countryRepository;
    @Autowired
    GlobalRepository globalRepository;
    @Autowired
    FavoritesCountryRepository favoritesCountryRepository;
    @Autowired
    FavoritesGlobalRepository favoritesGlobalRepository;

    @GetMapping("/countries")
    public List<Country> getCountriesData() {
        return (List<Country>) countryRepository.findAll();
    }

    @GetMapping("/global")
    public Global getGlobalData() {
        return (Global) globalRepository.findAll().get(0);
    }

    @GetMapping("/favoriteCountries")
    public List<FavoriteCountryEntity> getFavoriteCountriesData() {
        return (List<FavoriteCountryEntity>) favoritesCountryRepository.findAll();
    }

    @GetMapping("/favoriteGlobal")
    public List<FavoriteGlobalEntity> getFavoriteGlobalsData() {
        return (List<FavoriteGlobalEntity>) favoritesGlobalRepository.findAll();
    }

    @PostMapping("/favoriteCountries")
    void addFavoriteCountriesData(@RequestBody List<FavoriteCountryEntity> favoriteCountryEntities) {
        favoritesCountryRepository.saveAll(favoriteCountryEntities);
    }

    @PostMapping("/favoriteGlobal")
    void addFavoriteGlobalData(@RequestBody List<FavoriteGlobalEntity> favoriteGlobalEntities) {
        favoritesGlobalRepository.saveAll(favoriteGlobalEntities);
    }
}
