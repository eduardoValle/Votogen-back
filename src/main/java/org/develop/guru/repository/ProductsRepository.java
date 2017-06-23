package org.develop.guru.repository;

import org.develop.guru.entities.Products;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 *
 * Created by Luiz Eduardo on 27/03/2017.
 */

public interface ProductsRepository extends CrudRepository<Products, Integer> {

    Products findById(Integer id);

    @Modifying
    @Query("SELECT products FROM Products products")
    ArrayList<Products> selectBuyLifes();
}