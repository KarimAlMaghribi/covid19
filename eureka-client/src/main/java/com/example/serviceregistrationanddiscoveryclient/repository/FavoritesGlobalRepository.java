package com.example.serviceregistrationanddiscoveryclient.repository;

import com.example.serviceregistrationanddiscoveryclient.model.entity.FavoriteCountryEntity;
import com.example.serviceregistrationanddiscoveryclient.model.entity.FavoriteGlobalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FavoritesGlobalRepository extends MongoRepository<FavoriteGlobalEntity, String> {
    List<FavoriteGlobalEntity> findAll();
}