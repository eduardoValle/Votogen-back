package org.develop.guru.security;

import javax.validation.constraints.NotNull;

public class AuthenticationRequest {
	@NotNull
	private String email;

	@NotNull
	private String password;

	public AuthenticationRequest() {
		super();
	}

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

	public AuthenticationRequest(String email, String password) {
		this.setEmail(email);
		this.setPassword(password);
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
