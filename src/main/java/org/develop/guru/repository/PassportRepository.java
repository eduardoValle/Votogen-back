package org.develop.guru.repository;

import java.util.Optional;

import org.develop.guru.model.passport.Passport;
import org.develop.guru.model.passport.facebook.FacebookPassport;
import org.develop.guru.model.passport.password.PasswordPassport;
import org.develop.guru.security.SystemUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PassportRepository extends CrudRepository<Passport, Long> {

	@Query("SELECT p FROM Passport p WHERE p.user.id = ?1 AND TYPE(p) = ?2")
	Optional<Passport> findByUserIdAndType(Integer id, Class<? extends Passport> class1);
}
