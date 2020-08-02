package pl.cichy.onlineshop.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.cichy.onlineshop.model.Product;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProductRepository {

    List <Product> readAllProducts();

    Product getProductById(String productId);

    List <Product> getProductsByCategory(String category);

    List <Product> getProductsByManufacturer(String manufacturer);

    Product addProduct(Product product);
}
