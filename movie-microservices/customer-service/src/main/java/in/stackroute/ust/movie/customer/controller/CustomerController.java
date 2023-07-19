package in.stackroute.ust.movie.customer.controller;

import in.stackroute.ust.movie.customer.domain.Customer;
import in.stackroute.ust.movie.customer.dto.CustomerDto;
import in.stackroute.ust.movie.customer.dto.LoginDto;
import in.stackroute.ust.movie.customer.exceptions.CustomerAlreadyExistsException;
import in.stackroute.ust.movie.customer.exceptions.CustomerNotFoundException;
import in.stackroute.ust.movie.customer.service.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerServiceImpl;

    private Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomer(){
        logger.info("getAllCustomer");
        final var customerlist = customerServiceImpl.getAllCustomer();
        if(customerlist.isEmpty()){
            logger.error("CustomerList is empty");
            throw new CustomerNotFoundException(
                    String.format("CustomerList is empty"),
                    ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()
            );
        }
        final List<CustomerDto> Dtos = customerlist.stream().map(dtos -> convertToDto(dtos)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(Dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable int id){
        logger.info("getCustomer");
        final var customer = customerServiceImpl.getCustomer(id);
        if(customer.isEmpty()){
            logger.error("Customer not found");
            throw new CustomerNotFoundException(
              String.format("Customer not found"),
              ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(customer.get()));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable String email){
        logger.info("getCustomerByName");
        final var customer = customerServiceImpl.getByEmail(email);
        if(customer.isEmpty()){
            logger.error("Customer with email {} not found",email);
            throw new CustomerNotFoundException(
                    String.format("Customer with email {}",email),
                    ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(customer.get()));
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<CustomerDto> getCustomerByName(@PathVariable String name){
        logger.info("getCustomerByName");
        final var customer = customerServiceImpl.getByName(name);
        if(customer.isEmpty()){
            logger.error("Customer with email {} not found",name);
            throw new CustomerNotFoundException(
                    String.format("Customer with email {}",name),
                    ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(customer.get()));
    }



    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerdto){
        logger.info("addCustomer");
        final var customer = customerServiceImpl.getCustomer(customerdto.id());
        if(customer.isPresent()){
            logger.error("Customer already exists");
            throw new CustomerAlreadyExistsException(
                    String.format("Customer already exists"),
                    ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()
            );
        }
        final var newcustomer = customerServiceImpl.addCustomer(convertDtoToEntity(customerdto));
        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(newcustomer));
    }

    @PostMapping("/login")
    public ResponseEntity<CustomerDto> login(@Valid @RequestBody LoginDto login){
        var customer = customerServiceImpl.findByEmailandPassword(login.email(),login.password());
        if(customer.isEmpty()){
            logger.error("Customer not found");
            throw new CustomerNotFoundException(
                    String.format("Customer not found"),
                    ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(customer.get()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerdto,@PathVariable int id){
        logger.info("updating customer");
        final var customer = customerServiceImpl.getCustomer(customerdto.id());
        if(customer.isEmpty()){
            logger.error("Customer not found");
            throw new CustomerNotFoundException(
                    String.format("Customer not found"),
                    ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(customerServiceImpl.updateCustomer(convertDtoToEntity(customerdto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable int id){
        logger.info("Delete customer");
        final var customer = customerServiceImpl.getCustomer(id);
        if(customer.isEmpty()){
            logger.error("Customer not found");
            throw new CustomerNotFoundException(
                    String.format("Customer not found"),
                    ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(customerServiceImpl.deleteCustomer(customer.get())));
    }

    public Customer convertDtoToEntity(CustomerDto customerdto){
        Customer customer = new Customer();
        customer.setId(customerdto.id());
        customer.setName(customerdto.name());
        customer.setEmail(customerdto.email());
        customer.setPassword(customerdto.password());
        return customer;

    }

    public CustomerDto convertToDto(Customer customer){
        return new CustomerDto(customer.getId(),customer.getName(),customer.getEmail(),customer.getPassword());
    }

}
