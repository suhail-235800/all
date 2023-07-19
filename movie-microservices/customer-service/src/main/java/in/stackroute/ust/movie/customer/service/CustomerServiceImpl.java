package in.stackroute.ust.movie.customer.service;


import in.stackroute.ust.movie.customer.domain.Customer;
import in.stackroute.ust.movie.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomer(int id) {
        return customerRepository.findById(id);
    }

    public Customer deleteCustomer(Customer existingCustomer) {
        customerRepository.delete(existingCustomer);
        return existingCustomer;
    }

    @Override
    public Optional<Customer> getByEmail(String email) {
        return Optional.ofNullable(customerRepository.findByEmail(email));
    }

    @Override
    public Optional<Customer> getByName(String name) {
        return Optional.ofNullable(customerRepository.findByName(name));
    }

    @Override
    public Optional<Customer> findByEmailandPassword(String email, String password) {
        return customerRepository.findByEmailAndPassword(email,password);
    }
}
