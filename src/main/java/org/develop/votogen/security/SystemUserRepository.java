package org.develop.votogen.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SystemUserRepository extends CrudRepository<SystemUser, Integer> {

	Optional<SystemUser> findByEmail(String email);

	@Query(nativeQuery = true, value = "SELECT * from system_user where id =?1")
	Optional<SystemUser> findById(Integer id);
	
	@Query(nativeQuery = true, value = "SELECT * FROM user_historic h INNER JOIN system_user ON h.user_id = system_user.id where system_user.id =?1")
	SystemUser findUserhistoric(int id);
}
