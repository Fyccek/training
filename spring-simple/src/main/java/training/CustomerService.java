package training;

public class CustomerService {

    final CustomerDao customer;

    public CustomerService(CustomerDao customers) {
        this.customer = customers;
    }

    public void saveCustomer(String id, String name) {
        customer.saveCustomer(id, name);
    }
}