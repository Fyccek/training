package training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    public CustomerDao customerBean() {
        return new CustomerDao();
    }

    @Bean
    public CustomerService customerService() {
        return new CustomerService(customerBean());
    }
}