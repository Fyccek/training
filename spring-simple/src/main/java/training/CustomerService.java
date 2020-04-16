package training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {

    final CustomerDao customerDao;
    
    private final ApplicationEventPublisher publisher;
    
    private final boolean isUpperCase;

    public CustomerService(CustomerDao customerDao, ApplicationEventPublisher publisher,
    		@Value("${uppercase.enabled}") boolean upperCase) {
        this.isUpperCase = upperCase;
		this.publisher = publisher;
		this.customerDao = customerDao;
    }

    public Customer saveCustomer(String id, String name) {
    	
    	log.info("Save employee");
    	
    	if (id.equals(null) || id.isEmpty()) {
			throw new NullPointerException("id can not be null or empty");
		}
    	
    	Customer customer = customerDao.saveCustomer(id, convertName(name));
    	        
        publisher.publishEvent(new CustomerCreateEvent(this, name));
        
        return customer;
    }
    
    public Customer findEmployeeById(long id) {
        return customerDao.findCustomerById(id);
    }
    
    public Customer updateEmployee(long id, String name) {
        return customerDao.updateCustomer(id, convertName(name));
    }
    
    public void deleteCustomer(long id) {
        customerDao.deleteCustomer(id);
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