
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
    "NewConfirmed",
    "TotalConfirmed",
    "NewDeaths",
    "TotalDeaths",
    "NewRecovered",
    "TotalRecovered"
})
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "Global")
public class Global {
    @Id
    public String id;
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Global withNewConfirmed(Integer newConfirmed) {
        this.newConfirmed = newConfirmed;
        return this;
    }

    public Global withTotalConfirmed(Integer totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
        return this;
    }

    public Global withNewDeaths(Integer newDeaths) {
        this.newDeaths = newDeaths;
        return this;
    }

    public Global withTotalDeaths(Integer totalDeaths) {
        this.totalDeaths = totalDeaths;
        return this;
    }

    public Global withNewRecovered(Integer newRecovered) {
        this.newRecovered = newRecovered;
        return this;
    }

    public Global withTotalRecovered(Integer totalRecovered) {
        this.totalRecovered = totalRecovered;
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

    public Global withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
