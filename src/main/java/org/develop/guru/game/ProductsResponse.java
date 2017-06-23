package org.develop.guru.game;

import org.develop.guru.entities.Products;

import java.util.ArrayList;

/**
 *
 * Created by Luiz Eduardo on 06/06/2017.
 */

public class ProductsResponse {
    private ArrayList<Products> products = new ArrayList();

    public ProductsResponse() {
    }

    public ProductsResponse(ArrayList<Products> lifes) {
        this.products = lifes;
    }

    public ArrayList<Products> getLifes() {
        return products;
    }

    public void setLifes(ArrayList<Products> lifes) {
        this.products = lifes;
    }
}
