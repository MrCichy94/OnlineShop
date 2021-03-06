package pl.cichy.onlineshop.model.repository;

import pl.cichy.onlineshop.model.Cart;

public interface CartRepository {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);

}
