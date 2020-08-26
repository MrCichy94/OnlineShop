package pl.cichy.onlineshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.cichy.onlineshop.model.Cart;
import pl.cichy.onlineshop.model.NotRegisteredOrder;
import pl.cichy.onlineshop.service.CartService;
import pl.cichy.onlineshop.service.NotRegisteredOrderService;
import pl.cichy.onlineshop.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;
    private final NotRegisteredOrderService notRegisteredOrderService;
    private final CartService cartService;

    public OrderController(final OrderService orderService, final NotRegisteredOrderService notRegisteredOrderService, final CartService cartService) {
        this.orderService = orderService;
        this.notRegisteredOrderService = notRegisteredOrderService;
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
                                Model model, Pageable page) {
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
            notRegisteredOrder.setOrderPrice(cartService.read(sessionId).getGrandTotal());
            notRegisteredOrderService.save(notRegisteredOrder);
            logger.info("Not registered order saved!");
            model.addAttribute("cart", cartService.read(sessionId));
            model.addAttribute("NROrder", notRegisteredOrderService.findById(notRegisteredOrder.getId()));
            return "orderinfo";
        }
    }

    /*
    //PROBLEM WITH ID GENERATOR -TODO
    @GetMapping("/delete")
    public String deleteOrder(NotRegisteredOrder notRegisteredOrder) {

        if (notRegisteredOrderService.existsById(notRegisteredOrder.getId()))
        {
            notRegisteredOrderService.deleteById(notRegisteredOrder.getId());
            logger.info("Order removed from DB");
        }
        return "redirect:/products";
    }
     */


}
