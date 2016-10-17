package com.florian.bikes.json;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "empty_slots",
        "extra",
        "free_bikes",
        "id",
        "latitude",
        "longitude",
        "name",
        "timestamp"
})
public class Station {

    @JsonProperty("empty_slots")
    private Integer emptySlots;
    @JsonProperty("extra")
    private Extra extra;
    @JsonProperty("free_bikes")
    private Integer freeBikes;
    @JsonProperty("id")
    private String id;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("name")
    private String name;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The emptySlots
     */
    @JsonProperty("empty_slots")
    public Integer getEmptySlots() {
        return emptySlots;
    }

    /**
     * @param emptySlots The empty_slots
     */
    @JsonProperty("empty_slots")
    public void setEmptySlots(Integer emptySlots) {
        this.emptySlots = emptySlots;
    }

    /**
     * @return The extra
     */
    @JsonProperty("extra")
    public Extra getExtra() {
        return extra;
    }

    /**
     * @param extra The extra
     */
    @JsonProperty("extra")
    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    /**
     * @return The freeBikes
     */
    @JsonProperty("free_bikes")
    public Integer getFreeBikes() {
        return freeBikes;
    }

    /**
     * @param freeBikes The free_bikes
     */
    @JsonProperty("free_bikes")
    public void setFreeBikes(Integer freeBikes) {
        this.freeBikes = freeBikes;
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
     * @return The latitude
     */
    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude The latitude
     */
    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return The longitude
     */
    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude The longitude
     */
    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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
     * @return The timestamp
     */
    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp The timestamp
     */
    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
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
