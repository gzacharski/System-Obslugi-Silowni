package com.myprojects.gza.myGymApp.captcha;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
	"success",
	"challenge_ts",
	"hostname",
	"error-codes"
})
public class GoogleResponse {
	
	static enum ErrorCode{
		MissingSecret, InvalidSecret, MissingResponse, InvalidResponse, BadRequest,TimeoutOrDuplicate;
		
		private static Map<String, ErrorCode> errorsMap=new HashMap<String, GoogleResponse.ErrorCode>(6);
		
		static {
			errorsMap.put("missing-input-secret", MissingSecret);
			errorsMap.put("invalid-input-secret", InvalidSecret);
            errorsMap.put("missing-input-response", MissingResponse);
            errorsMap.put("invalid-input-response", InvalidResponse);
            errorsMap.put("bad-request", BadRequest);
            errorsMap.put("timeout-or-duplicate", TimeoutOrDuplicate);
		}
		
		@JsonCreator
		public static ErrorCode forValue(String value) {
			return errorsMap.get(value.toLowerCase());
		}
	}

	@JsonProperty("success")
	private boolean success;
	
	@JsonProperty("challenge_ts")
	private String challengeTs;
	
	@JsonProperty("hostname")
	private String hostname;
	
	@JsonProperty("error-codes")
	private ErrorCode[] errorCodes;
	
	@JsonProperty("success")
	public boolean isSuccess() {
		return success;
	}

	@JsonProperty("success")
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	@JsonProperty("challenge_ts")
	public String getChallengeTs() {
		return challengeTs;
	}
	
	@JsonProperty("challenge_ts")
	public void setChallengeTs(String challengeTs) {
		this.challengeTs = challengeTs;
	}

	@JsonProperty("hostname")
	public String getHostname() {
		return hostname;
	}
	
	@JsonProperty("hostname")
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
	@JsonProperty("error-codes")
	public ErrorCode[] getErrorCodes() {
		return errorCodes;
	}

	@JsonProperty("error-codes")
	public void setErrorCodes(ErrorCode[] errorCodes) {
		this.errorCodes = errorCodes;
	}
	
	@JsonIgnore
	public boolean hasClientError() {
		
		ErrorCode[] errors=getErrorCodes();
		if(errors==null) return false;
		
		for(ErrorCode error: errors) {
			switch(error) {
			case InvalidResponse:
			case MissingResponse:
			case BadRequest:
				return true;
			default:
				break;
			}
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "GoogleResponse [success=" + success + ", challengeTs=" + challengeTs + ", hostname=" + hostname
				+ ", errorCodes=" + Arrays.toString(errorCodes) + "]";
	}
	
	
}
