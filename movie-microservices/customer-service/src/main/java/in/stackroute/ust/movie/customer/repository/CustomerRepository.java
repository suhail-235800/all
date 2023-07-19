package in.stackroute.ust.movie.customer.repository;

import in.stackroute.ust.movie.customer.domain.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findByEmail(String email);
    Customer findByName(String name);

    Optional<Customer> findByEmailAndPassword(String email, String password);
}
