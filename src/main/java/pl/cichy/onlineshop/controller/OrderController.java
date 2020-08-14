package pl.cichy.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cichy.onlineshop.model.Adress;
import pl.cichy.onlineshop.model.NoRegistryOrder;
import pl.cichy.onlineshop.service.OrderService;

import javax.validation.Valid;

@Controller
@RequestMapping("/order")
public class OrderController {


    private final OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/P1234/2")
    public String process() {
        orderService.processOrder("P1234", 2);
        return "redirect:/products";
    }

    @RequestMapping
    public String showOrder(@ModelAttribute("currentOrder") @Valid NoRegistryOrder noRegistryOrder, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "order";
        }
        return "order";
    }
}
