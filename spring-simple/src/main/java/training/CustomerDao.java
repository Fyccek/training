package training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerDao {
	
	String id;
	String name;
	
	private List<String> customers = Collections.synchronizedList(new ArrayList<>());
	
	public void saveCustomer(String id, String name) {
		  customers.add(name);
	      System.out.println("Customer has been saved successfully");
	}
	
	public List<String> getCustomers() {
		return new ArrayList<String>(customers);
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
