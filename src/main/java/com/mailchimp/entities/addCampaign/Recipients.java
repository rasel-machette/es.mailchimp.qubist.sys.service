
package com.mailchimp.entities.addCampaign;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "list_id", "segment_opts" })
public class Recipients {

	@JsonProperty("list_id")
	private String listId;
	@JsonProperty("segment_opts")
	private SegmentOpts segmentOpts;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("list_id")
	public String getListId() {
		return listId;
	}

	@JsonProperty("list_id")
	public void setListId(String listId) {
		this.listId = listId;
	}

	@JsonProperty("segment_opts")
	public SegmentOpts getSegmentOpts() {
		return segmentOpts;
	}

	@JsonProperty("segment_opts")
	public void setSegmentOpts(SegmentOpts segmentOpts) {
		this.segmentOpts = segmentOpts;
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
