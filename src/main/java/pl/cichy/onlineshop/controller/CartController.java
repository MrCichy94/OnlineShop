package pl.cichy.onlineshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.cichy.onlineshop.exception.ProductNotFoundException;
import pl.cichy.onlineshop.model.Cart;
import pl.cichy.onlineshop.model.CartItem;
import pl.cichy.onlineshop.model.Product;
import pl.cichy.onlineshop.service.CartService;
import pl.cichy.onlineshop.service.ProductService;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);
    private final CartService cartService;
    private final ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    //@GetMapping("/{cartId}") NEED FOR JS+REACT FRONT _testgita_
    ResponseEntity <Cart> readCart(@PathVariable("cartId") String cartId) {
        logger.info("Cart found");
        return ResponseEntity.ok(cartService.read(cartId));
    }

    @GetMapping
    public String get(Model model, HttpServletRequest request) {

        //this is prepered empty cart with sesionID vs null cart id exception by thymeleaf
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);
        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }
        cartService.update(sessionId, cart);

        model.addAttribute("cart", cartService.read(sessionId));
        return "cart";
    }

    //REMOVING ITEM FROM CART - 2 controllers! Main remove + helping redirecting to solve problem in mobile SAFARI (iphone)
    @RequestMapping("/{productId}")
    public String removeItem(@PathVariable String productId, HttpServletRequest request, Model model) {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);

        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }

        Product product;
        //troll version to change, by 'category' use it
        if(productId.charAt(0)=='P') {
            product = productService.getProductById(productId);
        } else {
            product = productService.getItemById(productId);
        }

        if (product == null) {
            throw new IllegalArgumentException(new ProductNotFoundException(productId));
        }

        cart.removeCartItem(new CartItem(product));
        product.setUnitsInStock(product.getUnitsInStock() + product.getUnitsInOrder());
        product.setUnitsInOrder(0);
        logger.info("Item removed from cart");
        cartService.update(sessionId, cart);
        model.addAttribute("cart", cartService.read(sessionId));
        return "redirect:/cart";
    }

    //this controller is duplicated from /cart cuz we got redirect:/cart (/cart/cart send to /cart)
    @GetMapping("/cart")
    public String getFresh(Model model, HttpServletRequest request) {

        //this is prepered empty cart with sesionID vs null cart id exception by thymeleaf
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);
        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }
        cartService.update(sessionId, cart);

        model.addAttribute("cart", cartService.read(sessionId));
        return "cart";
    }

    //ADDING ITEM TO CART
    @RequestMapping(value = "/add/{productId}")
    public String addProduct(@PathVariable String productId, HttpServletRequest request, Model model) {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);
        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }

        Product product = productService.getProductById(productId);
        if (product == null) {
            throw new IllegalArgumentException(new ProductNotFoundException(productId));
        }

        //all this method i'm gonna move on to servis
        if (product.getUnitsInStock() > 0) {
            cart.addCartItem(new CartItem(product));
            product.setUnitsInStock(product.getUnitsInStock() - 1);
            product.setUnitsInOrder(product.getUnitsInOrder() + 1);
            logger.info("Item added to cart");
            cartService.update(sessionId, cart);
        } else {
            logger.info("Item can not be added to cart");
            //need to fix sending answer to user, there is no more product with given id
        }
        return "redirect:/cart";
    }

    //ADDING ITEM TO CART
    @RequestMapping(value = "/ad/{itemId}")
    public String addItem(@PathVariable String itemId, HttpServletRequest request, Model model) {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);
        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }

        Product item = productService.getItemById(itemId);
        if (item == null) {
            throw new IllegalArgumentException(new ProductNotFoundException(itemId));
        }

        //all this method i'm gonna move on to servis
        if (item.getUnitsInStock() > 0) {
            cart.addCartItem(new CartItem(item));
            item.setUnitsInStock(item.getUnitsInStock() - 1);
            item.setUnitsInOrder(item.getUnitsInOrder() + 1);
            logger.info("Item added to cart");
            cartService.update(sessionId, cart);
        } else {
            logger.info("Item can not be added to cart");
            //need to fix sending answer to user, there is no more product with given id
        }
        return "redirect:/cart";
    }
}
