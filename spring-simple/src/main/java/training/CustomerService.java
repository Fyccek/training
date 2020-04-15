package training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {

    final CustomerDao customer;
    
    private final ApplicationEventPublisher publisher;
    
    private final boolean isUpperCase;

    public CustomerService(CustomerDao customers, ApplicationEventPublisher publisher,
    		@Value("${uppercase.enabled}") boolean upperCase) {
        this.isUpperCase = upperCase;
		this.publisher = publisher;
		this.customer = customers;
    }

    public void saveCustomer(String id, String name) {
    	
    	log.info("Save employee");
    	
    	if (id.equals(null) || id.isEmpty()) {
			throw new NullPointerException("id can not be null or empty");
		}
    	
    	if (isUpperCase) {
    		name = name.toUpperCase();
		}
    	
        customer.saveCustomer(id, name);
        
        publisher.publishEvent(new CustomerCreateEvent(this, name));
    }
}