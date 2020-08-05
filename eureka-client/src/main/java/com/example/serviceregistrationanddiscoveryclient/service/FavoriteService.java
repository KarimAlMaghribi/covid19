package com.example.serviceregistrationanddiscoveryclient.service;

import com.example.serviceregistrationanddiscoveryclient.dto.model.FavoriteCountryDTO;
import com.example.serviceregistrationanddiscoveryclient.dto.model.FavoriteGlobalDTO;
import com.example.serviceregistrationanddiscoveryclient.dto.model.GlobalDTO;
import com.example.serviceregistrationanddiscoveryclient.model.entity.FavoriteCountryEntity;

import java.util.List;

public interface FavoriteService {
    List<FavoriteCountryDTO> findFavoriteCountries();
    FavoriteGlobalDTO findFavoriteGlobal();
    void setFavoriteCountries (List<FavoriteCountryDTO> favoriteCountryDTOS);
    void setFavoriteGlobal(FavoriteGlobalDTO favoriteGlobal);
    void deleteFavoriteCountryByName(String countryName);
    void deleteFavoriteGlobal();
    void deleteAllFavorites();
}
