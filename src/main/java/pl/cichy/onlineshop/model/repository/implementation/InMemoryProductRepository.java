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
    private final List<Product> listOfItems = new ArrayList<Product>();

    public InMemoryProductRepository() {

        //SETS (KAMEA+SHIRT)
        Product product1 = new Product("P1234","'Edmund'", new BigDecimal("129.99"));
        product1.setDescription("Piękna i elegancka koszula męska, zdobiona czarnymi podszewkami kołnierzyka i mankietów, oraz czarnymi guzikami. W zestawie ze złotymi reniferami dodającymi smaku i kunsztu całości.");
        product1.setCategory("Koszule męskie");
        product1.setManufacturer("RafaellO");
        product1.setUnitsInStock(100);
        product1.setUnitsInOrder(0);
        product1.setImage("images/set/photo1.jpg");

        Product product2 = new Product("P1235","'Diana'", new BigDecimal("149.99"));
        product2.setDescription("Piękna i elegancka koszula damska, zdobiona czarnymi podszewkami kołnierzyka i mankietów, oraz czarnymi guzikami. W zestawie z czarną kameą, a w niej mieniącym się diamentem.");
        product2.setCategory("Koszule damskie");
        product2.setManufacturer("RafaellO");
        product2.setUnitsInStock(90);
        product2.setUnitsInOrder(0);
        product2.setImage("images/set/photo2.jpg");

        Product product3 = new Product("P1236","'Elizabeth'", new BigDecimal("139.99"));
        product3.setDescription("Piękna i elegancka koszula damska, zdobiona czarnymi podszewkami kołnierzyka i mankietów, oraz czarnymi guzikami. W zestawie z czarną kokardą wypełnioną królewską perłą.");
        product3.setCategory("Koszule damskie");
        product3.setManufacturer("RafaellO");
        product3.setUnitsInStock(60);
        product3.setUnitsInOrder(0);
        product3.setImage("images/set/photo3.jpg");

        Product product4 = new Product("P1237","'Samantha'", new BigDecimal("129.99"));
        product4.setDescription("Piękna i elegancka koszula damska, zdobiona czarnymi podszewkami kołnierzyka i mankietów, oraz czarnymi guzikami. W zestawie z czarną kokardą wypełnioną królewską perłą.");
        product4.setCategory("Koszule męskie");
        product4.setManufacturer("RafaellO");
        product4.setUnitsInStock(70);
        product4.setUnitsInOrder(0);
        product4.setImage("images/set/photo4.jpg");

        Product product5 = new Product("P1238","'William'", new BigDecimal("129.99"));
        product5.setDescription("Piękna i elegancka koszula damska, zdobiona czarnymi podszewkami kołnierzyka i mankietów, oraz czarnymi guzikami. W zestawie z czarną kokardą wypełnioną królewską perłą.");
        product5.setCategory("Koszule damskie");
        product5.setManufacturer("RafaellO");
        product5.setUnitsInStock(80);
        product5.setUnitsInOrder(0);
        product5.setImage("images/set/photo5.jpg");

        //ADDS (FREE ITEMS)
        Product item1 = new Product("I1234","'Elizabeth'", new BigDecimal("29.99"));
        item1.setDescription("Złotyme renifery dodające smaku i kunsztu całości.");
        item1.setCategory("Dodatki");
        item1.setManufacturer("R&R");
        item1.setUnitsInStock(100);
        item1.setUnitsInOrder(0);
        item1.setImage("images/single/gotowy_1.png");

        Product item2 = new Product("I1235","'Diana'", new BigDecimal("49.99"));
        item2.setDescription("Czarną kamea, a w niej mieniącym się diamentem.");
        item2.setCategory("Dodatki");
        item2.setManufacturer("R&R");
        item2.setUnitsInStock(90);
        item2.setUnitsInOrder(0);
        item2.setImage("images/single/gotowy_2.png");

        Product item3 = new Product("I1236","'Edmund'", new BigDecimal("39.99"));
        item3.setDescription("Czarną kokarda wypełniona królewską perłą.");
        item3.setCategory("Dodatki");
        item3.setManufacturer("R&R");
        item3.setUnitsInStock(60);
        item3.setUnitsInOrder(0);
        item3.setImage("images/single/gotowy_3.png");

        Product item4 = new Product("I1237","'Samantha'", new BigDecimal("29.99"));
        item4.setDescription("Czarną kokarda wypełniona królewską perłą.");
        item4.setCategory("Dodatki");
        item4.setManufacturer("R&R");
        item4.setUnitsInStock(70);
        item4.setUnitsInOrder(0);
        item4.setImage("images/single/gotowy_4.png");

        Product item5 = new Product("I1238","'Miranda'", new BigDecimal("29.99"));
        item5.setDescription("Czarną kokarda wypełniona królewską perłą.");
        item5.setCategory("Dodatki");
        item5.setManufacturer("R&R");
        item5.setUnitsInStock(80);
        item5.setUnitsInOrder(0);
        item5.setImage("images/single/gotowy_5.png");

        listOfProducts.add(product1);
        listOfProducts.add(product2);
        listOfProducts.add(product3);
        listOfProducts.add(product4);
        listOfProducts.add(product5);

        listOfItems.add(item1);
        listOfItems.add(item2);
        listOfItems.add(item3);
        listOfItems.add(item4);
        listOfItems.add(item5);
    }

    public List <Product> readAllProducts() {
        return listOfProducts;
    }
    public List <Product> readAllItems() {
        return listOfItems;
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

    public Product getItemById(String productId) {

        //for thymeleaf exception changed initializing from null to new Product()
        Product productById = new Product();

        for(Product product : listOfItems) {
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

    public List<Product> getItemsByCategory(String category) {

        List<Product> itemsByCategory = new ArrayList<Product>();

        for(Product product: listOfItems) {
            if(category.equalsIgnoreCase(product.getCategory())){
                itemsByCategory.add(product);
            }
        }

        return itemsByCategory;
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

    public List<Product> getItemsByManufacturer(String manufacturer) {

        List<Product> itemsByManufacturer = new ArrayList<Product>();

        for(Product product: listOfItems) {
            if(manufacturer.equalsIgnoreCase(product.getManufacturer())){
                itemsByManufacturer.add(product);
            }
        }

        return itemsByManufacturer;
    }

    public Product addProduct(Product product) {
        listOfProducts.add(product);
        return product;
    }

    public Product addItem(Product product) {
        listOfItems.add(product);
        return product;
    }
}
