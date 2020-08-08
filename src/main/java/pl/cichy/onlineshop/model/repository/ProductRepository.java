package pl.cichy.onlineshop.model.repository;

import pl.cichy.onlineshop.model.Product;
import java.util.List;

public interface ProductRepository {

    List <Product> readAllProducts();

    Product getProductById(String productId);

    List <Product> getProductsByCategory(String category);

    List <Product> getProductsByManufacturer(String manufacturer);

    Product addProduct(Product product);
}
