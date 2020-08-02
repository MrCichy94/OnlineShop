package pl.cichy.onlineshop.service;

import pl.cichy.onlineshop.model.Order;

public interface OrderService {

    void processOrder(String productId, int count);

    Long saveOrder(Order order);

}
