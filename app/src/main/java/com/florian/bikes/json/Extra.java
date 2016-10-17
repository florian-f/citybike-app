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
        "description",
        "internal_id",
        "slots",
        "status",
        "uid"
})
public class Extra {

    @JsonProperty("description")
    private String description;
    @JsonProperty("internal_id")
    private String internalId;
    @JsonProperty("slots")
    private String slots;
    @JsonProperty("status")
    private String status;
    @JsonProperty("uid")
    private String uid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The internalId
     */
    @JsonProperty("internal_id")
    public String getInternalId() {
        return internalId;
    }

    /**
     * @param internalId The internal_id
     */
    @JsonProperty("internal_id")
    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    /**
     * @return The slots
     */
    @JsonProperty("slots")
    public String getSlots() {
        return slots;
    }

    /**
     * @param slots The slots
     */
    @JsonProperty("slots")
    public void setSlots(String slots) {
        this.slots = slots;
    }

    /**
     * @return The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The uid
     */
    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    /**
     * @param uid The uid
     */
    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
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
