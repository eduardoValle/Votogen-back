package org.develop.votogen.service;

import org.springframework.data.domain.Sort;

/**
 * Created by donat on 31-Mar-17.
 */
public interface OrderManager {
    void placeOrder(Sort.Order order);
}
