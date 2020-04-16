package training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
	
	private List<Customer> customers = Collections.synchronizedList(new ArrayList<>());
	
	private AtomicLong sequence = new AtomicLong();
	 
	public Customer saveCustomer(String id, String name) {
		Customer customer = new Customer(sequence.getAndIncrement(), name);
		customers.add(customer);
	    return customer;
	}
	
	public Customer findCustomerById(long id) {
        return customers.stream().filter(e -> e.getId()== id).findFirst().orElseThrow(() -> new IllegalArgumentException("Not found"));
    }
	
	

    public Customer updateCustomer(long id, String name) {
        Customer customer = findCustomerById(id);
        customer.setName(name);
        return customer;
    }
    

    public void deleteCustomer(long id) {
        customers = customers.stream().filter(e -> e.getId() != id).collect(Collectors.toList());
    }
    
	public List<Customer> getCustomers() {
		return new ArrayList<Customer>(customers);
	}
}
