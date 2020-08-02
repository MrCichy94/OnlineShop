package pl.cichy.onlineshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.cichy.onlineshop.model.Customer;
import pl.cichy.onlineshop.service.CustomerService;

import java.util.List;

@Controller
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    ResponseEntity <List<Customer>> readAllCustomers(){
        logger.info("Custom pageable");
        return ResponseEntity.ok(customerService.readAllCustomers());
    }

}
