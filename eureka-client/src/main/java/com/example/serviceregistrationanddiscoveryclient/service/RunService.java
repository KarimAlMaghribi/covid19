package com.example.serviceregistrationanddiscoveryclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class RunService{
    @Autowired
    DataService dataService;
    Logger logger;


    @Scheduled(fixedRateString = "${sample.schedule.string}")
    public void scheduleTaskDataToMongo(){
        logger.info("Country Data Insert");
        dataService.setAllCountries();
        logger.info("Global Data Insert");
        dataService.setGlobalData();
    }


}
