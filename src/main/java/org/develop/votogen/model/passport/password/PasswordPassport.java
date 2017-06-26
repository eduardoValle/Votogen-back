package org.develop.votogen.model.passport.password;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.develop.votogen.model.passport.Passport;
import org.develop.votogen.security.SystemUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue(PasswordPassport.DESCRIMINATOR)
public class PasswordPassport extends Passport {
	public static final String DESCRIMINATOR = "PasswordPassport";

	@JsonIgnore
	private String encryptedPassword;

	// constructor
	public PasswordPassport(SystemUser user) {
		super(user);
	}

	protected PasswordPassport() {
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setPassword(String password) {
		this.encryptedPassword = new BCryptPasswordEncoder().encode(password);
	}

}
