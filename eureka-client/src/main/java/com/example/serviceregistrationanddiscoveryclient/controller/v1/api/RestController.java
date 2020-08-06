package com.example.serviceregistrationanddiscoveryclient.controller.v1.api;

import com.example.serviceregistrationanddiscoveryclient.dto.model.CountryDTO;
import com.example.serviceregistrationanddiscoveryclient.dto.model.FavoriteCountryDTO;
import com.example.serviceregistrationanddiscoveryclient.dto.model.FavoriteGlobalDTO;
import com.example.serviceregistrationanddiscoveryclient.dto.model.GlobalDTO;
import com.example.serviceregistrationanddiscoveryclient.model.entity.FavoriteCountryEntity;
import com.example.serviceregistrationanddiscoveryclient.model.entity.FavoriteGlobalEntity;
import com.example.serviceregistrationanddiscoveryclient.repository.FavoritesGlobalRepository;
import com.example.serviceregistrationanddiscoveryclient.repository.GlobalRepository;
import com.example.serviceregistrationanddiscoveryclient.service.DataService;
import com.example.serviceregistrationanddiscoveryclient.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    DataService dataService;
    @Autowired
    GlobalRepository globalRepository;

    FavoriteService favoriteService;


    @GetMapping("/countries")
    public List<CountryDTO> getCountriesData() {
        return (List<CountryDTO>) dataService.getAllCountries();
    }

    @GetMapping("/global")
    public GlobalDTO getGlobalData() {
        return (GlobalDTO) dataService.getGlobalData();
    }

    @GetMapping("/favoriteCountries")
    public List<FavoriteCountryDTO> getFavoriteCountriesData() {
        return (List<FavoriteCountryDTO>) favoriteService.findFavoriteCountries();
    }

    @GetMapping("/favoriteGlobal")
    public FavoriteGlobalDTO getFavoriteGlobalsData() {
        return (FavoriteGlobalDTO) favoriteService.findFavoriteGlobal();
    }

    @PostMapping("/favoriteCountries")
    void addFavoriteCountriesData(@RequestBody List<FavoriteCountryDTO> favoriteCountryEntities) {
        favoriteService.setFavoriteCountries(favoriteCountryEntities);
    }

    @PostMapping("/favoriteGlobal")
    void addFavoriteGlobalData(@RequestBody FavoriteGlobalDTO favoriteGlobalEntities) {
        if (favoriteGlobalEntities.getNewConfirmed() > 0 )
        favoriteService.setFavoriteGlobal(favoriteGlobalEntities);
    }

    @PostMapping("/favoriteCountries/delete/{name}")
    public void deleteFavoriteCountryByName(@PathVariable String countryName) {
        favoriteService.deleteFavoriteCountryByName(countryName);
    }

    @PostMapping("/favoriteGlobal/delete")
    public void deleteFavoriteGlobal() {
        favoriteService.deleteFavoriteGlobal();
    }

    @PostMapping("/favorites/deleteall")
    public void deleteAllFavorites() {
        deleteAllFavorites();
    }
}
