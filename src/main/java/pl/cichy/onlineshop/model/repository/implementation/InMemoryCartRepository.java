package pl.cichy.onlineshop.model.repository.implementation;

import org.springframework.stereotype.Repository;
import pl.cichy.onlineshop.model.Cart;
import pl.cichy.onlineshop.model.repository.CartRepository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryCartRepository implements CartRepository {

    private final Map<String, Cart> listOfCarts;

    public InMemoryCartRepository() {
        listOfCarts = new HashMap<String, Cart>();
    }

    public Cart create(Cart cart) {
        if (listOfCarts.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("Can not create a cart. A cart with the given id (%) already exists", cart.getCartId()));
        }

        listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }

    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    public void update(String cartId, Cart cart) {
        if(!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Can not update cart. The cart with the given id (%) does not exist", cartId));
        }

        listOfCarts.put(cartId, cart);
    }

    public void delete(String cartId) {
        if(!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Can not delete cart. The cart with the given id (%) does not exist", cartId));
        }

        listOfCarts.remove(cartId);
    }
}
