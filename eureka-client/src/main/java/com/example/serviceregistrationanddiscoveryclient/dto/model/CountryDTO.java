package com.example.serviceregistrationanddiscoveryclient.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDTO {
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
