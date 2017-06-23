package org.develop.guru.repository;

import org.develop.guru.entities.Codes;
import org.develop.guru.model.passport.Passport;
import org.develop.guru.security.SystemUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CodeRepository extends CrudRepository<Codes, Integer> {

    Optional<Codes> findByCode(String code);
    @Query(nativeQuery = true, value = "SELECT * from codes where id =?1")
    Codes findById(Integer id);

}
