
package com.mailchimp.entities.updateCampaignSettings;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "campaign", "notes" })
public class Salesforce {

	@JsonProperty("campaign")
	private Boolean campaign;
	@JsonProperty("notes")
	private Boolean notes;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("campaign")
	public Boolean getCampaign() {
		return campaign;
	}

	@JsonProperty("campaign")
	public void setCampaign(Boolean campaign) {
		this.campaign = campaign;
	}

	@JsonProperty("notes")
	public Boolean getNotes() {
		return notes;
	}

	@JsonProperty("notes")
	public void setNotes(Boolean notes) {
		this.notes = notes;
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
