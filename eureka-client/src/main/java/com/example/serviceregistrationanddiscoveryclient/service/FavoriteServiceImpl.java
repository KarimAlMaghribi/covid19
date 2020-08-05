package com.example.serviceregistrationanddiscoveryclient.service;

import com.example.serviceregistrationanddiscoveryclient.dto.mapper.FavoritesMapper;
import com.example.serviceregistrationanddiscoveryclient.dto.model.FavoriteCountryDTO;
import com.example.serviceregistrationanddiscoveryclient.dto.model.FavoriteGlobalDTO;
import com.example.serviceregistrationanddiscoveryclient.dto.model.GlobalDTO;
import com.example.serviceregistrationanddiscoveryclient.model.entity.FavoriteCountryEntity;
import com.example.serviceregistrationanddiscoveryclient.repository.FavoritesCountryRepository;
import com.example.serviceregistrationanddiscoveryclient.repository.FavoritesGlobalRepository;
import com.example.serviceregistrationanddiscoveryclient.repository.GlobalRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class FavoriteServiceImpl implements FavoriteService{
    @Autowired
    FavoritesCountryRepository favoritesCountryRepository;

    @Autowired
    FavoritesGlobalRepository favoritesGlobalRepository;

    @Autowired
    GlobalRepository globalRepository;

    @Override
    public List<FavoriteCountryDTO> findFavoriteCountries() {
        List<FavoriteCountryDTO> favoriteCountryDTOS = new ArrayList<>();
        List<FavoriteCountryEntity> favoriteCountryEntities = favoritesCountryRepository.findAll();

        for (FavoriteCountryEntity favoriteCountry: favoriteCountryEntities) {
            favoriteCountryDTOS.add(FavoritesMapper.toFavoritesCountryDTO(favoriteCountry));
        }
        return favoriteCountryDTOS;
    }

    @Override
    public FavoriteGlobalDTO findFavoriteGlobal() {
        return FavoritesMapper.toFavoritesGlobalDTO(favoritesGlobalRepository.findAll().get(0));
    }

    FavoritesMapper f = new FavoritesMapper();
    @Override
    public void setFavoriteCountries(List<FavoriteCountryDTO> favoriteCountryDTOS) {
        for (FavoriteCountryDTO favoriteGlobalDTO: favoriteCountryDTOS){
            favoritesCountryRepository.save(f.toFavoritesCountryEntity(favoriteGlobalDTO));
        }
    }

    @Override
    public void setFavoriteGlobal(FavoriteGlobalDTO favoriteGlobal) {
        favoritesGlobalRepository.save();
    }

    @Override
    public void deleteFavoriteCountryByName(String countryName) {
        List<FavoriteCountryEntity> favoriteCountryEntities = favoritesCountryRepository.findAll();
        for (FavoriteCountryEntity favoriteCountryEntity: favoriteCountryEntities) {
            if (favoriteCountryEntity.getCountry().getCountry() == countryName) {
                favoritesCountryRepository.delete(favoriteCountryEntity);
            }
        }
    }

    @Override
    public void deleteFavoriteGlobal() {
        favoritesGlobalRepository.deleteAll();
    }

    @Override
    public void deleteAllFavorites() {
        favoritesGlobalRepository.deleteAll();
        favoritesCountryRepository.deleteAll();
    }
}
