package com.example.covidservice.model.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class GlobalEntity {

    private int newConfirmed;
    private int totalConfirmed;
    private int newDeaths;
    private int totalDeaths;
    private int newRecovered;
    private int totalRecovered;
    // getters and setters
}