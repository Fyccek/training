package training;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String... args) {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CustomerConfig.class);

        try (context) {
            CustomerService customerService = context.getBean(CustomerService.class);

            customerService.saveCustomer("1", "Pista");
        }
    }
}