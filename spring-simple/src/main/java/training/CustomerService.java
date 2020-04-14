package training;

public class CustomerService {

    final Customers customer;

    public CustomerService(Customers customers) {
        this.customer = customers;
    }

    public void saveCustomer(String id, String name) {
        customer.saveCustomer(id, name);
    }
}