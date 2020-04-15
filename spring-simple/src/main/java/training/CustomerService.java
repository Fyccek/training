package training;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    final CustomerDao customer;
    
    private final ApplicationEventPublisher publisher;

    public CustomerService(CustomerDao customers, ApplicationEventPublisher publisher) {
        this.publisher = publisher;
		this.customer = customers;
    }

    public void saveCustomer(String id, String name) {
    	
    	if (id.equals(null) || id.isEmpty()) {
			throw new NullPointerException("id can not be null or empty");
		}
    	
    	String nameWithUpperCase = name.toUpperCase();
    	
        customer.saveCustomer(id, nameWithUpperCase);
        
        publisher.publishEvent(new CustomerCreateEvent(this, name));
    }
}