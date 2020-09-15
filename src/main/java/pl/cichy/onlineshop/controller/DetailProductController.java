package pl.cichy.onlineshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.cichy.onlineshop.service.ProductService;

@Controller
@RequestMapping("/product")
public class DetailProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    public DetailProductController(final ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(params = "productId")
    public String getById(@RequestParam String productId, Model model){
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @RequestMapping(params = "itemId")
    public String getByItemId(@RequestParam String itemId, Model model){
        model.addAttribute("product", productService.getItemById(itemId));
        return "product";
    }

}
