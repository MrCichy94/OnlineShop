package pl.cichy.onlineshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.cichy.onlineshop.exception.NoProductsFoundUnderCategoryException;
import pl.cichy.onlineshop.model.Product;
import pl.cichy.onlineshop.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.net.URI;
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

    @GetMapping("category/{category}")
    ResponseEntity <List<Product>> getProductsByCategory(@PathVariable("category") String category) {

        List <Product> products = productService.getProductsByCategory(category);
        if (products == null || products.isEmpty()) {
            throw new NoProductsFoundUnderCategoryException();
        }

        logger.info("By category");

        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    @GetMapping("manufacturer/{manufacturer}")
    ResponseEntity <List<Product>> getProductsByManufacturer(@PathVariable("manufacturer") String manufacturer) {

        List <Product> products = productService.getProductsByManufacturer(manufacturer);
        if (products == null || products.isEmpty()) {
            throw new NoProductsFoundUnderCategoryException();
        }

        logger.info("By manufacturer");

        return ResponseEntity.ok(productService.getProductsByManufacturer(manufacturer));
    }

    @GetMapping("product/{productId}")
    ResponseEntity <Product> getProductById(@PathVariable String productId) {

        logger.info("By ID");
        return ResponseEntity.ok(productService.getProductById(productId));

    }

    @PostMapping("/addProduct")
    ResponseEntity <Product> addNewProduct(@RequestBody @Valid Product toCreate){
        Product result = productService.addProduct(toCreate);
        logger.warn("Dodano nowy produkt!");
        return ResponseEntity.created(URI.create("/" + result.getProductId())).body(result);
    }


}
