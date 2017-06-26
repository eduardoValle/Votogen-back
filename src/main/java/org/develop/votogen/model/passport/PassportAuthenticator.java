package org.develop.votogen.model.passport;

import java.util.Optional;

import org.develop.votogen.security.SystemUser;

public abstract class PassportAuthenticator {

	abstract public Optional<SystemUser> authenticate(String email, String authCode);

}
