package in.stackroute.ust.movie.customer.service;

import in.stackroute.ust.movie.customer.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomer();
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Optional<Customer> getCustomer(int id);
    Customer deleteCustomer(Customer existingCustomer);

    Optional<Customer> getByEmail(String name);

    Optional<Customer> getByName(String name);

    Optional<Customer> findByEmailandPassword(String email, String password);
}
