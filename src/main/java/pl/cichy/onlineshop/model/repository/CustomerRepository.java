package pl.cichy.onlineshop.model.repository;

import pl.cichy.onlineshop.model.Customer;

import java.util.List;

public interface CustomerRepository {

    List <Customer> readAllCustomers();

    Customer getCustomerById(String customerId);
}
