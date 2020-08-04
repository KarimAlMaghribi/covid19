package com.example.serviceregistrationanddiscoveryclient.service;

import com.example.serviceregistrationanddiscoveryclient.dto.model.FavoriteCountryDTO;

import java.util.List;

public class FavoriteServiceImpl implements FavoriteService{
    @Override
    public List<FavoriteCountryDTO> findFavoriteCountries() {
        return null;
    }

    @Override
    public List<FavoriteCountryDTO> setFavoriteCountries(List<FavoriteCountryDTO> favoriteCountryDTOS) {
        return null;
    }

    @Override
    public void deleteFavoriteCountryByName(String countryName) {

    }

    @Override
    public void deleteFavoriteGlobal() {

    }

    @Override
    public void deleteAllFavorites() {

    }
}
