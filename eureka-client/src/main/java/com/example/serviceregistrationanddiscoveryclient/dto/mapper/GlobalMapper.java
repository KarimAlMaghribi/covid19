package com.example.serviceregistrationanddiscoveryclient.dto.mapper;

import com.example.serviceregistrationanddiscoveryclient.dto.model.GlobalDTO;
import com.example.serviceregistrationanddiscoveryclient.model.entity.GlobalEntity;
import com.example.serviceregistrationanddiscoveryclient.remoteDataSource.Global;

public class GlobalMapper {
    public static GlobalDTO toGlobalDTO (GlobalEntity globalEntity) {
        return new GlobalDTO()
                .setNewConfirmed(globalEntity.getNewConfirmed())
                .setTotalConfirmed(globalEntity.getTotalConfirmed())
                .setNewDeaths(globalEntity.getTotalDeaths())
                .setTotalDeaths(globalEntity.getTotalDeaths())
                .setNewRecovered(globalEntity.getNewRecovered())
                .setTotalRecovered(globalEntity.getTotalRecovered());
    }
    public static GlobalDTO toGlobalDTO (Global globalEntity) {
        return new GlobalDTO()
                .setNewConfirmed(globalEntity.getNewConfirmed())
                .setTotalConfirmed(globalEntity.getTotalConfirmed())
                .setNewDeaths(globalEntity.getTotalDeaths())
                .setTotalDeaths(globalEntity.getTotalDeaths())
                .setNewRecovered(globalEntity.getNewRecovered())
                .setTotalRecovered(globalEntity.getTotalRecovered());
    }
}
