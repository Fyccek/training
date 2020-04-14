package training;

public class CustomerService {

    final CustomerDao customer;

    public CustomerService(CustomerDao customers) {
        this.customer = customers;
    }

    public void saveCustomer(String id, String name) {
    	
    	if (id.equals(null) || id.isEmpty()) {
			throw new NullPointerException("id can not be null or empty");
		}
    	
    	String nameWithUpperCase = name.toUpperCase();
    	
        customer.saveCustomer(id, nameWithUpperCase);
    }
}