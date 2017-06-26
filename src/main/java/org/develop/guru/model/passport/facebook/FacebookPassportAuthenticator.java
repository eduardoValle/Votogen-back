package org.develop.guru.model.passport.facebook;

import java.util.Optional;

import org.develop.guru.model.passport.PassportAuthenticator;
import org.develop.guru.repository.PassportRepository;
import org.develop.guru.security.SystemUser;
import org.develop.guru.security.SystemUserRepository;

import org.develop.guru.service.FacebookService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacebookPassportAuthenticator extends PassportAuthenticator {

	@Autowired
	private FacebookService facebook;
	@Autowired
	private SystemUserRepository userRepo;
	@Autowired
	private PassportRepository passportRepo;

	@Override
	public Optional<SystemUser> authenticate(String email, String accessToken) {
		try {
			JSONObject obj = facebook.getUserFields(accessToken, "email");

			String realEmail = obj.getString("email");

			SystemUser user = userRepo.findByEmail(realEmail).orElseGet(() -> {
				SystemUser newUser = new SystemUser(realEmail);
				return userRepo.save(newUser);
			});
			FacebookPassport passport = (FacebookPassport) passportRepo
					.findByUserIdAndType(user.getId(), FacebookPassport.class).orElseGet(() -> {
						FacebookPassport newPassport = new FacebookPassport(user, accessToken);
						return passportRepo.save(newPassport);
					});
			passport.setAccessToken(accessToken);
			passportRepo.save(passport);
			return Optional.of(user);
		} catch (Exception e) {
			return Optional.ofNullable(null);
		}

	}
}
