package pl.cichy.onlineshop.model.repository.implementation;

import org.springframework.stereotype.Repository;
import pl.cichy.onlineshop.model.Customer;
import pl.cichy.onlineshop.model.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private final List<Customer> listOfCustomers = new ArrayList<Customer>();

    public InMemoryCustomerRepository() {

        Customer Janusz = new Customer("Janusz","Krakow", 2, "1234");
        Customer Andrzej = new Customer("Andrzej","Wroclaw", 3, "1235");
        Customer Anna = new Customer("Anna","Warszawa", 1, "1236");

        listOfCustomers.add(Janusz);
        listOfCustomers.add(Andrzej);
        listOfCustomers.add(Anna);
    }

    public List<Customer> readAllCustomers() {
        return listOfCustomers;
    }

    public Customer getCustomerById(String CustomerId) {
        Customer CustomerById = null;
        for(Customer customer : listOfCustomers) {
            if(customer!=null && customer.getCustomerId()!=null && customer.getCustomerId().equals(CustomerId)){
                CustomerById = customer;
                break;
            }
        }
        if(CustomerById == null){
            throw new IllegalArgumentException("Brak produktu o wskazanym id:"+ CustomerId);
        }
        return CustomerById;
    }
}
