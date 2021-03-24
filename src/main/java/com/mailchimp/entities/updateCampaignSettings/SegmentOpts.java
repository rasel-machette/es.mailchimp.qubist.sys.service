
package com.mailchimp.entities.updateCampaignSettings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "saved_segment_id",
    "prebuilt_segment_id",
    "match",
    "conditions"
})
public class SegmentOpts {

    @JsonProperty("saved_segment_id")
    private Integer savedSegmentId;
    @JsonProperty("prebuilt_segment_id")
    private String prebuiltSegmentId;
    @JsonProperty("match")
    private String match;
    @JsonProperty("conditions")
    private List<Object> conditions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("saved_segment_id")
    public Integer getSavedSegmentId() {
        return savedSegmentId;
    }

    @JsonProperty("saved_segment_id")
    public void setSavedSegmentId(Integer savedSegmentId) {
        this.savedSegmentId = savedSegmentId;
    }

    @JsonProperty("prebuilt_segment_id")
    public String getPrebuiltSegmentId() {
        return prebuiltSegmentId;
    }

    @JsonProperty("prebuilt_segment_id")
    public void setPrebuiltSegmentId(String prebuiltSegmentId) {
        this.prebuiltSegmentId = prebuiltSegmentId;
    }

    @JsonProperty("match")
    public String getMatch() {
        return match;
    }

    @JsonProperty("match")
    public void setMatch(String match) {
        this.match = match;
    }

    @JsonProperty("conditions")
    public List<Object> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Object> conditions) {
        this.conditions = conditions;
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
