package pl.cichy.onlineshop.model.repository;

import org.springframework.data.domain.Page;
import pl.cichy.onlineshop.model.Product;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductRepository {

    List <Product> readAllProducts();

}
