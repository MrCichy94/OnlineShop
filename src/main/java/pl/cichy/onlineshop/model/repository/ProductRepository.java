package pl.cichy.onlineshop.model.repository;

import pl.cichy.onlineshop.model.Product;
import java.util.List;

public interface ProductRepository {

    List <Product> readAllProducts();
    List <Product> readAllItems();

    Product getProductById(String productId);
    Product getItemById(String productId);

    List <Product> getProductsByCategory(String category);
    List <Product> getItemsByCategory(String category);

    List <Product> getProductsByManufacturer(String manufacturer);
    List <Product> getItemsByManufacturer(String manufacturer);

    //maybe merge?
    Product addProduct(Product product);
    Product addItem(Product product);
}
