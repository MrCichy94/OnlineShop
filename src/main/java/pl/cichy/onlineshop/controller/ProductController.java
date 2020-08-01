package pl.cichy.onlineshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cichy.onlineshop.exception.NoProductsFoundUnderCategoryException;
import pl.cichy.onlineshop.model.Product;
import pl.cichy.onlineshop.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(params = {"!sort", "!page", "!size"})
    ResponseEntity <List<Product>> readAllProducts() {
        logger.info("Custom pageable");
        return ResponseEntity.ok(productService.readAllProducts());
    }

    @GetMapping("/{category}")
    ResponseEntity <List<Product>> getProductsByCategory(Model model, @PathVariable("category") String category) {

        List <Product> products = productService.getProductsByCategory(category);
        if (products == null || products.isEmpty()) {
            throw new NoProductsFoundUnderCategoryException();
        }

        logger.info("Custom pageable");

        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }


}
