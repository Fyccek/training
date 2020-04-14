package training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    public Customers customerBean() {
        return new Customers();
    }

    @Bean
    public CustomerService customerService() {
        return new CustomerService(customerBean());
    }
}