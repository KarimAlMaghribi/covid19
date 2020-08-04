package com.example.serviceregistrationanddiscoveryclient.dto.mapper;

import com.example.serviceregistrationanddiscoveryclient.dto.model.FavoriteGlobalDTO;
import com.example.serviceregistrationanddiscoveryclient.dto.model.FavoriteCountryDTO;
import com.example.serviceregistrationanddiscoveryclient.model.entity.FavoriteCountryEntity;
import com.example.serviceregistrationanddiscoveryclient.model.entity.FavoriteGlobalEntity;

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
}
