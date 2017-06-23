package org.develop.guru.repository;

import org.develop.guru.entities.UserPlan;
import org.develop.guru.security.SystemUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 *
 * Created by Luiz Eduardo on 12/04/2017.
 */
public interface UserPlanRepository extends CrudRepository<UserPlan, Integer> {

    ArrayList<UserPlan> findByUser(SystemUser user);

    @Query("UPDATE UserPlan userPlan SET userPlan.active = true WHERE userPlan.id = ?1")
    void activatePlan(int id);

    @Query("UPDATE UserPlan userPlan SET userPlan.active = false WHERE userPlan.id = ?1")
    void disablePlan(int id);

    @Query("SELECT userPlan FROM UserPlan userPlan WHERE userPlan.active = true AND userPlan.user = ?1")
    ArrayList<UserPlan> selectAvailableLives(SystemUser user);
}
