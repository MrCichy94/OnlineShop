package pl.cichy.onlineshop.service.implementation;

import org.apache.commons.collections.functors.ExceptionClosure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.cichy.onlineshop.exception.NoProductsFoundUnderCategoryException;
import pl.cichy.onlineshop.exception.ProductNotFoundException;
import pl.cichy.onlineshop.model.Product;
import pl.cichy.onlineshop.model.repository.ProductRepository;
import pl.cichy.onlineshop.model.repository.implementation.InMemoryProductRepository;
import pl.cichy.onlineshop.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    //@Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> readAllProducts() {
        return productRepository.readAllProducts();
    }

    public Product getProductById(String productId) {
        return productRepository.getProductById(productId);
    }

    public List <Product> getProductsByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }

    public List <Product> getProductsByManufacturer(String manufacturer) {
        return productRepository.getProductsByManufacturer(manufacturer);
    }

    public Product addProduct(Product product) {
        productRepository.addProduct(product);
        return product;
        // TODO Auto-generated method stub, remember about validation!
    }
}
