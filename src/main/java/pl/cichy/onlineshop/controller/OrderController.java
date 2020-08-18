package pl.cichy.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cichy.onlineshop.model.Cart;
import pl.cichy.onlineshop.model.NotRegisteredOrder;
import pl.cichy.onlineshop.model.repository.CartRepository;
import pl.cichy.onlineshop.service.CartService;
import pl.cichy.onlineshop.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@RequestMapping("/order")
public class OrderController {


    private final OrderService orderService;
    private final CartService cartService;

    public OrderController(final OrderService orderService, CartService cartService) {
        this.orderService = orderService;
        this.cartService = cartService;
    }

    @RequestMapping("/P1234/2")
    public String process() {
        orderService.processOrder("P1234", 2);
        return "redirect:/products";
    }

    @GetMapping
    public String showOrderForm(@ModelAttribute("currentOrder") NotRegisteredOrder notRegisteredOrder,
                                HttpServletRequest request, Model model) {
        String sessionId = request.getSession(true).getId();
        //if someone click order without items in cart, no existing cart with serialVersionUID
        Cart cart = cartService.read(sessionId);
        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }
        cartService.update(sessionId, cart);

        model.addAttribute("cart", cartService.read(sessionId));
        return "orderform";
    }


    @PostMapping
    public String showOrderInfo(@Valid @ModelAttribute("currentOrder") NotRegisteredOrder notRegisteredOrder,
                                BindingResult bindingResult,
                                HttpServletRequest request,
                                Model model) {
        {

            String sessionId = request.getSession(true).getId();
            //if someone click order without items in cart, no existing cart with serialVersionUID
            Cart cart = cartService.read(sessionId);
            if (cart == null) {
                cart = cartService.create(new Cart(sessionId));
            }
            cartService.update(sessionId, cart);

            if (bindingResult.hasErrors()) {
                model.addAttribute("cart", cartService.read(sessionId));
                return "orderform";
            }
            return "orderinfo";
        }
    }
}
