package org.develop.votogen.security;

import javax.validation.constraints.NotNull;

public class EditRequest {
	@NotNull
	private String email;

	private String name;

	private String dateNasc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public String getDateNasc() {
		return dateNasc;
	}

	public void setDateNasc(String dateNasc) {
		this.dateNasc = dateNasc;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
