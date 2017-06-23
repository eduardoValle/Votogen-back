package org.develop.guru.security;

public class FacebookRequest {

	private Long clientId;
	private String code;
	private String redirectUri;

	public FacebookRequest(Long clientId, String code, String redirectUri) {
		super();
		this.clientId = clientId;
		this.code = code;
		this.redirectUri = redirectUri;
	}

	public FacebookRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
