package pl.cichy.onlineshop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cichy.onlineshop.model.Customer;
import pl.cichy.onlineshop.model.repository.CustomerRepository;
import pl.cichy.onlineshop.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List <Customer> readAllCustomers() {
        return customerRepository.readAllCustomers();
    }
}
