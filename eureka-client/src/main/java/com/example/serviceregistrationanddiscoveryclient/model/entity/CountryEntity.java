package com.example.serviceregistrationanddiscoveryclient.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "Country")
public class CountryEntity {
    @Id
    public String id;
    public String country;
    public String countryCode;
    public String slug;
    public Integer newConfirmed;
    public Integer totalConfirmed;
    public Integer newDeaths;
    public Integer totalDeaths;
    public Integer newRecovered;
    public Integer totalRecovered;
    public String date;
}
