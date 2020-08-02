package pl.cichy.onlineshop.service.implementation;

import org.springframework.stereotype.Service;
import pl.cichy.onlineshop.model.Order;
import pl.cichy.onlineshop.model.Product;
import pl.cichy.onlineshop.model.repository.OrderRepository;
import pl.cichy.onlineshop.model.repository.ProductRepository;
import pl.cichy.onlineshop.service.CartService;
import pl.cichy.onlineshop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {


    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final CartService cartService;

    public OrderServiceImpl(final ProductRepository productRepository,
                            final OrderRepository orderRepository,
                            final CartService cartService) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.cartService = cartService;
    }

    public void processOrder(String productId, int count) {
        Product productById = productRepository.getProductById(productId);

        if(productById.getUnitsInStock() < count){
            throw new IllegalArgumentException("Zbyt mało towaru. Obecna liczba sztuk w magazynie: "+ productById.getUnitsInStock());
        }

        productById.setUnitsInStock(productById.getUnitsInStock() - count);
    }

    public Long saveOrder(Order order) {
        Long orderId = orderRepository.saveOrder(order);
        cartService.delete(order.getCart().getCartId());
        return orderId;
    }
}
