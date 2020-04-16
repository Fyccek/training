package training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import training.backend.Customer;
import training.backend.CustomerConfig;
import training.backend.CustomerRepository;
import training.backend.CustomerService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CustomerConfig.class)
@Sql(statements = "delete from customers")
public class CustomerServiceIT {

    @Autowired
    private CustomerService service;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void init() {
    	customerRepository.deleteAll();
    }

    @Test
    void test_saveCustomer() {
        service.saveCustomer("1", "John Doe");
        service.saveCustomer("2", "Jack Doe");
        List<Customer> customers = customerRepository.findAll();
        ArrayList<String> savedCustomers = new ArrayList<String>();
        savedCustomers.add("JOHN DOE");
        savedCustomers.add("JACK DOE");
        assertEquals(savedCustomers, customers.stream().map(Customer::getName).collect(Collectors.toList()));
    }

    @Test
    void test_findCustomerById() {
        Customer customer = service.saveCustomer("1", "John Doe");
        Customer found = service.findCustomerById(customer.getId());
        assertEquals("JOHN DOE", found.getName());
    }

    @Test
    void test_updateCustomer() {
        Customer customer = service.saveCustomer("1", "John Doe");
        service.updateCustomer(customer.getId(), "Jack Doe");
        Customer found = service.findCustomerById(customer.getId());
        assertEquals("JACK DOE", found.getName());
    }

    @Test
    void test_deleteCustomer() {
        Customer customer = service.saveCustomer("1", "John Doe");
        service.deleteCustomer(customer.getId());
        List<Customer> customers = service.listCustomers();
        assertEquals(0, customers.size());
    }


}
