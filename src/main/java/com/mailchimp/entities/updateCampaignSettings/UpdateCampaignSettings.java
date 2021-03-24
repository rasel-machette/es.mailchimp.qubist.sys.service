
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
@JsonPropertyOrder({ "recipients", "settings", "tracking", "social_card" })
public class UpdateCampaignSettings {

	@JsonProperty("recipients")
	private Recipients recipients;
	@JsonProperty("settings")
	private Settings settings;
	@JsonProperty("tracking")
	private Tracking tracking;
	@JsonProperty("social_card")
	private SocialCard socialCard;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("recipients")
	public Recipients getRecipients() {
		return recipients;
	}

	@JsonProperty("recipients")
	public void setRecipients(Recipients recipients) {
		this.recipients = recipients;
	}

	@JsonProperty("settings")
	public Settings getSettings() {
		return settings;
	}

	@JsonProperty("settings")
	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	@JsonProperty("tracking")
	public Tracking getTracking() {
		return tracking;
	}

	@JsonProperty("tracking")
	public void setTracking(Tracking tracking) {
		this.tracking = tracking;
	}

	@JsonProperty("social_card")
	public SocialCard getSocialCard() {
		return socialCard;
	}

	@JsonProperty("social_card")
	public void setSocialCard(SocialCard socialCard) {
		this.socialCard = socialCard;
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
