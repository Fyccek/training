package training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
	
	private List<String> customers = Collections.synchronizedList(new ArrayList<>());
	
	public void saveCustomer(String id, String name) {
		  customers.add(name);
	      System.out.println("Customer has been saved successfully");
	}
	
	public List<String> getCustomers() {
		return new ArrayList<String>(customers);
	}
}
