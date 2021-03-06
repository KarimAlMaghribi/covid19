
package com.example.serviceregistrationanddiscoveryclient.remoteDataSource;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Global",
    "Countries",
    "Date"
})
public class DataImpl {

    @JsonProperty("Global")
    public Global global;
    @JsonProperty("Countries")
    public List<Country> countries = null;
    @JsonProperty("Date")
    public String date;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public DataImpl withGlobal(Global global) {
        this.global = global;
        return this;
    }

    public DataImpl withCountries(List<Country> countries) {
        this.countries = countries;
        return this;
    }

    public DataImpl withDate(String date) {
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

    public DataImpl withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
