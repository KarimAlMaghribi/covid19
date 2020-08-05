package com.example.serviceregistrationanddiscoveryclient.service;

import com.example.serviceregistrationanddiscoveryclient.dto.model.FavoriteCountryDTO;
import com.example.serviceregistrationanddiscoveryclient.model.entity.FavoriteCountryEntity;

import java.util.List;

public interface FavoriteService {
    List<FavoriteCountryDTO> findFavoriteCountries();
    void setFavoriteCountries (List<FavoriteCountryDTO> favoriteCountryDTOS);
    void deleteFavoriteCountryByName(String countryName);
    void deleteFavoriteGlobal();
    void deleteAllFavorites();
}
