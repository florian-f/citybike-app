package com.florian.bikes.json;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "company",
        "href",
        "id",
        "location",
        "name",
        "stations"
})
public class Network {

    @JsonProperty("company")
    private List<String> company = new ArrayList<String>();
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("name")
    private String name;
    @JsonProperty("stations")
    private List<Station> stations = new ArrayList<Station>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The company
     */
    @JsonProperty("company")
    public List<String> getCompany() {
        return company;
    }

    /**
     * @param company The company
     */
    @JsonProperty("company")
    public void setCompany(List<String> company) {
        this.company = company;
    }

    /**
     * @return The href
     */
    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    /**
     * @param href The href
     */
    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * @return The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The location
     */
    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    /**
     * @param location The location
     */
    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @return The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The stations
     */
    @JsonProperty("stations")
    public List<Station> getStations() {
        return stations;
    }

    /**
     * @param stations The stations
     */
    @JsonProperty("stations")
    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
