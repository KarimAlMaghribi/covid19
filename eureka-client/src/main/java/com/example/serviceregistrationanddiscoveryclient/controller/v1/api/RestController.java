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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    DataService dataService;
    @Autowired
    GlobalRepository globalRepository;

    FavoriteService favoriteService;

 //   @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/countries")
    public List<CountryDTO> getCountriesData() {
        return (List<CountryDTO>) dataService.getAllCountries();
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/global")
    public GlobalDTO getGlobalData() {
        return (GlobalDTO) dataService.getGlobalData();
    }
  //  @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/favoriteCountries")
    public List<FavoriteCountryDTO> getFavoriteCountriesData() {
        return (List<FavoriteCountryDTO>) favoriteService.findFavoriteCountries();
    }
//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/favoriteGlobal")
    public FavoriteGlobalDTO getFavoriteGlobalsData() {
        return (FavoriteGlobalDTO) favoriteService.findFavoriteGlobal();
    }
 //   @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/favoriteCountries")
    void addFavoriteCountriesData(@RequestBody List<FavoriteCountryDTO> favoriteCountryEntities) {
        favoriteService.setFavoriteCountries(favoriteCountryEntities);
    }
 //   @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/favoriteGlobal")
    void addFavoriteGlobalData(@RequestBody FavoriteGlobalDTO favoriteGlobalEntities) {
        if (favoriteGlobalEntities.getNewConfirmed() > 0 )
        favoriteService.setFavoriteGlobal(favoriteGlobalEntities);
    }
  //  @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/favoriteCountries/delete/{name}")
    public void deleteFavoriteCountryByName(@PathVariable String countryName) {
        favoriteService.deleteFavoriteCountryByName(countryName);
    }
 //   @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/favoriteGlobal/delete")
    public void deleteFavoriteGlobal() {
        favoriteService.deleteFavoriteGlobal();
    }
  //  @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/favorites/deleteall")
    public void deleteAllFavorites() {
        deleteAllFavorites();
    }
}
