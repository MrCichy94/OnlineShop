package pl.cichy.onlineshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cichy.onlineshop.service.NotRegisteredOrderService;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private final NotRegisteredOrderService notRegisteredOrderService;

    public OrdersController(final NotRegisteredOrderService notRegisteredOrderService) {
        this.notRegisteredOrderService = notRegisteredOrderService;
    }

    @GetMapping
    public String readAllOrders(Model model, Pageable page) {
        model.addAttribute("orders", notRegisteredOrderService.findAll(page));
        logger.info("Read all orders.");
        return "orders";
    }
}
