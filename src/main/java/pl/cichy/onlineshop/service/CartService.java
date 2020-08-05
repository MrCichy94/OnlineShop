package pl.cichy.onlineshop.service;

import pl.cichy.onlineshop.model.Cart;
import pl.cichy.onlineshop.model.Product;

import java.util.List;

public interface CartService {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);

    List <Product> readProductInCart(String cartId);

}
