package org.develop.guru.model.passport.facebook;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.develop.guru.model.passport.Passport;
import org.develop.guru.security.SystemUser;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue(FacebookPassport.DESCRIMINATOR)
public class FacebookPassport extends Passport {
	public static final String DESCRIMINATOR = "FacebookPassport";

	@JsonIgnore
	private String accessToken;

	// constructor
	public FacebookPassport(SystemUser user, String accessToken) {
		super(user);
		this.accessToken = accessToken;
	}

	public FacebookPassport(SystemUser user) {
		super(user);
	}

	protected FacebookPassport() {
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
