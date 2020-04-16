package training.backend;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class LoggerService implements ApplicationListener<CustomerCreateEvent> {

	@Override
	public void onApplicationEvent(CustomerCreateEvent event) {
		System.out.println("Customer has been created: " + event.getName());
	}

}
