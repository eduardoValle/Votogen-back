/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.develop.votogen.repository;

import org.develop.votogen.entities.Historic;
import org.develop.votogen.security.SystemUser;
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