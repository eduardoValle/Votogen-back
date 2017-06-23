package org.develop.guru.model.passport;

import java.util.Optional;

import org.develop.guru.security.SystemUser;

public abstract class PassportAuthenticator {

	abstract public Optional<SystemUser> authenticate(String email, String authCode);

}
