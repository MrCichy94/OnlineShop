package pl.cichy.onlineshop.model.repository.implementation;

import org.springframework.stereotype.Repository;
import pl.cichy.onlineshop.exception.ProductNotFoundException;
import pl.cichy.onlineshop.model.Product;
import pl.cichy.onlineshop.model.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private ProductRepository productRepository;

    private final List<Product> listOfProducts = new ArrayList<Product>();

    public InMemoryProductRepository() {

        Product dreamer = new Product("P1234","Zestaw 'Dreamer'", new BigDecimal("129.99"));
        dreamer.setDescription("Piękna i elegancka koszula męska, zdobiona czarnymi podszewkami kołnierzyka i mankietów, oraz czarnymi guzikami. W zestawie ze złotymi reniferami dodającymi smaku i kunsztu całości.");
        dreamer.setCategory("Koszule męskie");
        dreamer.setManufacturer("RafaellO");
        dreamer.setUnitsInStock(100);
        dreamer.setUnitsInOrder(0);
        dreamer.setImage("images/photo1.jpg");

        Product diana = new Product("P1235","Zestaw 'Diana'", new BigDecimal("149.99"));
        diana.setDescription("Piękna i elegancka koszula damska, zdobiona czarnymi podszewkami kołnierzyka i mankietów, oraz czarnymi guzikami. W zestawie z czarną kameą, a w niej mieniącym się diamentem.");
        diana.setCategory("Koszule damskie");
        diana.setManufacturer("RafaellO");
        diana.setUnitsInStock(40);
        diana.setUnitsInOrder(0);
        diana.setImage("images/photo2.jpg");

        Product elizabeth = new Product("P1236","Zestaw 'Elizabeth'", new BigDecimal("139.99"));
        elizabeth.setDescription("Piękna i elegancka koszula damska, zdobiona czarnymi podszewkami kołnierzyka i mankietów, oraz czarnymi guzikami. W zestawie z czarną kokardą wypełnioną królewską perłą.");
        elizabeth.setCategory("Koszule damskie");
        elizabeth.setManufacturer("RafaellO");
        elizabeth.setUnitsInStock(60);
        elizabeth.setUnitsInOrder(0);
        elizabeth.setImage("images/photo3.jpg");

        listOfProducts.add(dreamer);
        listOfProducts.add(diana);
        listOfProducts.add(elizabeth);
    }

    public List <Product> readAllProducts() {
        return listOfProducts;
    }

    public Product getProductById(String productId) {

        //for thymeleaf exception changed initializing from null to new Product()
        Product productById = new Product();

        for(Product product : listOfProducts) {
            if(product != null && product.getProductId() != null && product.getProductId().equals(productId)){
                productById = product;
                break;
            }
        }

        if(productById == null){
            throw new ProductNotFoundException(productId);
        }

        return productById;
    }

    public List<Product> getProductsByCategory(String category) {

        List<Product> productsByCategory = new ArrayList<Product>();

        for(Product product: listOfProducts) {
            if(category.equalsIgnoreCase(product.getCategory())){
                productsByCategory.add(product);
            }
        }

        return productsByCategory;
    }

    public List<Product> getProductsByManufacturer(String manufacturer) {

        List<Product> productsByManufacturer = new ArrayList<Product>();

        for(Product product: listOfProducts) {
            if(manufacturer.equalsIgnoreCase(product.getManufacturer())){
                productsByManufacturer.add(product);
            }
        }

        return productsByManufacturer;
    }

    public Product addProduct(Product product) {
        listOfProducts.add(product);
        return product;
    }
}
