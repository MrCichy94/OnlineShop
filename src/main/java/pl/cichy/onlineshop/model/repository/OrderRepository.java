package pl.cichy.onlineshop.model.repository;

import pl.cichy.onlineshop.model.NotRegisteredOrder;
import pl.cichy.onlineshop.model.Order;

public interface OrderRepository {

    Long saveOrder(Order order);

}
