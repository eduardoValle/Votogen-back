package org.develop.guru.repository;

import org.develop.guru.entities.Life;
import org.develop.guru.security.SystemUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * Created by Luiz Eduardo on 27/03/2017.
 */

public interface LifeRepository extends CrudRepository<Life, Integer> {

    ArrayList<Life> findByUser(SystemUser user);

    @Modifying
    @Query("UPDATE Life life SET life.dataConsumo = ?1 WHERE life.id = ?2")
    void setDataConsumo(LocalDateTime dataConsumo, int id);

    @Modifying
    @Query("SELECT life FROM Life life WHERE life.dataConsumo = null AND life.user = ?1 ORDER BY life.dataExpiracao ASC")
    ArrayList<Life> selectAvailableLives(SystemUser user);
}