package pl.cichy.onlineshop.model.repository.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import pl.cichy.onlineshop.exception.ProductNotFoundException;
import pl.cichy.onlineshop.model.Product;
import pl.cichy.onlineshop.model.repository.ProductRepository;

import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private ProductRepository productRepository;

    private List<Product> listOfProducts = new ArrayList<Product>();

    public InMemoryProductRepository() {

        Product iphone = new Product("P1234","iPhone 5s", new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym ekranem o rozdzielczości 640×1136 i 8-megapikselowym aparatem");
        iphone.setCategory("Smartfon");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);
        iphone.setImage("images/photo1.jpg");

        Product laptop_dell = new Product("P1235","Dell Inspiron", new BigDecimal(700));
        laptop_dell.setDescription("Dell Inspiron, 14-calowy laptop (czarny)z procesorem Intel Core 3. generacji, do tego 2gb pamięci ram DDR3!");
        laptop_dell.setCategory("Laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1000);
        laptop_dell.setImage("images/photo2.jpg");

        Product tablet_Nexus = new Product("P1236","Nexus 7", new BigDecimal(300));
        tablet_Nexus.setDescription("Google Nexus 7 jest najlżejszym 7-calowym tabletem z 4-rdzeniowym procesorem Qualcomm Snapdragon™ S4 Pro");
        tablet_Nexus.setCategory("Tablet");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setUnitsInStock(1000);
        tablet_Nexus.setImage("images/photo3.jpg");

        listOfProducts.add(iphone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_Nexus);
    }

    public List <Product> readAllProducts() {
        return listOfProducts;
    }

    public Product getProductById(String productId) {

        Product productById = null;

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
