/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.develop.guru.repository;

import org.develop.guru.entities.Historic;
import org.develop.guru.security.SystemUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author motoka
 */
public interface HistoricRepository extends CrudRepository<Historic, Integer> {

    Page<Historic> findByUser(SystemUser user, Pageable pageRequest);
}