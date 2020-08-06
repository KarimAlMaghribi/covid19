package com.example.serviceregistrationanddiscoveryclient.dto.mapper;

import com.example.serviceregistrationanddiscoveryclient.dto.model.FavoriteGlobalDTO;
import com.example.serviceregistrationanddiscoveryclient.dto.model.FavoriteCountryDTO;
import com.example.serviceregistrationanddiscoveryclient.model.entity.FavoriteCountryEntity;
import com.example.serviceregistrationanddiscoveryclient.model.entity.FavoriteGlobalEntity;
import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.Country;
import com.example.serviceregistrationanddiscoveryclient.repository.CountryRepository;
import com.example.serviceregistrationanddiscoveryclient.repository.GlobalRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FavoritesMapper {
    public static FavoriteCountryDTO toFavoritesCountryDTO(FavoriteCountryEntity countryEntity) {
        return new FavoriteCountryDTO()
                .setId(countryEntity.getId())
                .setCountryName(countryEntity.getCountry().getCountry());
    }

    public static FavoriteGlobalDTO toFavoritesGlobalDTO(FavoriteGlobalEntity globalEntity) {
        return new FavoriteGlobalDTO()
                .setNewConfirmed(globalEntity.getGlobal().getNewConfirmed());
    }

    @Autowired
    CountryRepository countryRepository;

    public  FavoriteCountryEntity toFavoritesCountryEntity(FavoriteCountryDTO favoriteCountryDTO) {
        String countryName = favoriteCountryDTO.getCountryName();
        List<Country> countryList = countryRepository.findAll();
        FavoriteCountryEntity favoriteCountryEntity = new FavoriteCountryEntity();
        for(Country country: countryList) {
            if (country.getCountry() == countryName) {
                favoriteCountryEntity =  new FavoriteCountryEntity()
                        .setCountry(country);
            }
        }
        return favoriteCountryEntity;
    }

    @Autowired
    GlobalRepository globalRepository;
    public  FavoriteGlobalEntity toFavoritesGlobalEntity(FavoriteGlobalDTO favoriteGlobalDTO) {
        return new FavoriteGlobalEntity()
                .setGlobal(globalRepository.findAll().get(0));
    }


}
