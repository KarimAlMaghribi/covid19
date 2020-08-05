
package com.example.serviceregistrationanddiscoveryclient.remoteDataSource;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Country",
    "CountryCode",
    "Slug",
    "NewConfirmed",
    "TotalConfirmed",
    "NewDeaths",
    "TotalDeaths",
    "NewRecovered",
    "TotalRecovered",
    "Date",
    "Premium"
})

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "Country")
public class Country {
    @Id
    public String id;
    @JsonProperty("Country")
    public String country;
    @JsonProperty("CountryCode")
    public String countryCode;
    @JsonProperty("Slug")
    public String slug;
    @JsonProperty("NewConfirmed")
    public Integer newConfirmed;
    @JsonProperty("TotalConfirmed")
    public Integer totalConfirmed;
    @JsonProperty("NewDeaths")
    public Integer newDeaths;
    @JsonProperty("TotalDeaths")
    public Integer totalDeaths;
    @JsonProperty("NewRecovered")
    public Integer newRecovered;
    @JsonProperty("TotalRecovered")
    public Integer totalRecovered;
    @JsonProperty("Date")
    public String date;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Country withCountry(String country) {
        this.country = country;
        return this;
    }

    public Country withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public Country withSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public Country withNewConfirmed(Integer newConfirmed) {
        this.newConfirmed = newConfirmed;
        return this;
    }

    public Country withTotalConfirmed(Integer totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
        return this;
    }

    public Country withNewDeaths(Integer newDeaths) {
        this.newDeaths = newDeaths;
        return this;
    }

    public Country withTotalDeaths(Integer totalDeaths) {
        this.totalDeaths = totalDeaths;
        return this;
    }

    public Country withNewRecovered(Integer newRecovered) {
        this.newRecovered = newRecovered;
        return this;
    }

    public Country withTotalRecovered(Integer totalRecovered) {
        this.totalRecovered = totalRecovered;
        return this;
    }

    public Country withDate(String date) {
        this.date = date;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Country withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
