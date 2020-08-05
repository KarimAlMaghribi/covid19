package com.example.serviceregistrationanddiscoveryclient.repository;

import com.example.serviceregistrationanddiscoveryclient.model.entity.FavoriteCountryEntity;
import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.Global;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FavoritesCountryRepository extends MongoRepository<FavoriteCountryEntity, String> {
    List<FavoriteCountryEntity> findAll();
}
