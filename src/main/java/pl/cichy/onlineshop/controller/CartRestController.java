package pl.cichy.onlineshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.cichy.onlineshop.exception.ProductNotFoundException;
import pl.cichy.onlineshop.model.Cart;
import pl.cichy.onlineshop.model.CartItem;
import pl.cichy.onlineshop.model.Product;
import pl.cichy.onlineshop.service.CartService;
import pl.cichy.onlineshop.service.ProductService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/rest/cart")
public class CartRestController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final CartService cartService;
    private final ProductService productService;

    public CartRestController(final CartService cartService, final ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Cart create(@RequestBody Cart cart) {
        logger.info("Cart created");
        return cartService.create(cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId) {
        logger.info("Cart readed");
        return cartService.read(cartId);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart) {
        logger.info("Cart updated");
        cartService.update(cartId, cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") String cartId) {
        logger.info("Cart deleted");
        cartService.delete(cartId);
    }

    //HERE WAS PUT METHOD - changed to no-value
    @GetMapping(value = "/add/{productId}")
    @ResponseStatus(value = HttpStatus.RESET_CONTENT)
    public void addItem(@PathVariable String productId, HttpServletRequest request) {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);
        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }

        Product product = productService.getProductById(productId);
        if (product == null) {
            throw new IllegalArgumentException(new ProductNotFoundException(productId));
        }

        cart.addCartItem(new CartItem(product));
        logger.info("Item added to cart");
        cartService.update(sessionId, cart);
    }

    @GetMapping(value = "/remove/{productId}")
    @ResponseStatus(value = HttpStatus.RESET_CONTENT)
    public void removeItem(@PathVariable String productId, HttpServletRequest request) {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);

        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }

        Product product = productService.getProductById(productId);
        if (product == null) {
            throw new IllegalArgumentException(new ProductNotFoundException(productId));
        }

        cart.removeCartItem(new CartItem(product));
        logger.info("Item removed from cart");
        cartService.update(sessionId, cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handleClientErrors(Exception ex) { }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Internal server error")
    public void handleServerErrors(Exception ex) { }
}

