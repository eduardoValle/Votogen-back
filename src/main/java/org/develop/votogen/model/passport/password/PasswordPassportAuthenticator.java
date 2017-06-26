package org.develop.votogen.model.passport.password;

import java.util.Optional;

import org.develop.votogen.model.passport.PassportAuthenticator;
import org.develop.votogen.repository.PassportRepository;
import org.develop.votogen.security.SystemUser;
import org.develop.votogen.security.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordPassportAuthenticator extends PassportAuthenticator {

	@Autowired
	private SystemUserRepository userRepo;
	@Autowired
	private PassportRepository passportRepo;

	@Override
	public Optional<SystemUser> authenticate(String email, String password) {
		SystemUser user = userRepo.findByEmail(email).orElseThrow(() -> new UserNotFoundException("Usuário não registrado"));
		PasswordPassport passport = (PasswordPassport) passportRepo.findByUserIdAndType(user.getId(), PasswordPassport.class).get();
		BCryptPasswordEncoder encrypted = new BCryptPasswordEncoder();
		return Optional.ofNullable(encrypted.matches(password, passport.getEncryptedPassword()) ? user : null);
	}

}
