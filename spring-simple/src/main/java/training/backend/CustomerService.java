package training.backend;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {
	
    final CustomerRepository customerRepository;

    final CustomerDao customerDao;
    
    private final ApplicationEventPublisher publisher;
    
    private final boolean isUpperCase;

    public CustomerService(CustomerDao customerDao, ApplicationEventPublisher publisher,
    		@Value("${uppercase.enabled}") boolean upperCase, CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
		this.isUpperCase = upperCase;
		this.publisher = publisher;
		this.customerDao = customerDao;
    }

    @Transactional
    public Customer saveCustomer(String id, String name) {
    	
    	log.info("Save employee");
    	
    	if (id.equals(null) || id.isEmpty()) {
			throw new NullPointerException("id can not be null or empty");
		}
    	
    	Customer customer = customerRepository.save(new Customer(convertName(name)));
    	        
        publisher.publishEvent(new CustomerCreateEvent(this, name));
        
        return customer;
    }
    
    public Customer findCustomerById(long id) {
    	return customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }
    
    @Transactional
    public Customer updateCustomer(long id, String name) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        customer.setName(convertName(name));
        return customer;
    }
    
    @Transactional
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }
    
    
    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }
    
    public void emptyCustomers() {
    	customerDao.emptyCustomers();
    }
    
    private String convertName(String name) {
        if (isUpperCase) {
            return name.toUpperCase();
        }
        else {
            return name;
        }
    }
}