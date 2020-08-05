package pl.cichy.onlineshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.cichy.onlineshop.model.Cart;
import pl.cichy.onlineshop.service.CartService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    //@GetMapping("/{cartId}")
    ResponseEntity <Cart> readCart(@PathVariable("cartId") String cartId) {
        logger.info("Cart found");
        return ResponseEntity.ok(cartService.read(cartId));
    }

    @RequestMapping
    public String get(Model model, HttpServletRequest request) {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);
        model.addAttribute("cart", cartService.read(sessionId));
        return "cart";
    }

    //@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public String getCart2(@PathVariable(value = "cartId") String cartId, Model model) {
        model.addAttribute("cart", cartService.read(cartId));
        return "cart";
    }



}
