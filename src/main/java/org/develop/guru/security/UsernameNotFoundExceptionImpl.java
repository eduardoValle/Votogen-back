package org.develop.guru.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class UsernameNotFoundExceptionImpl extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsernameNotFoundExceptionImpl(String message) {
		super(message);
	}

}
