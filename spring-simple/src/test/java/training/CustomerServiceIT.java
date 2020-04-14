package training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CustomerConfig.class)
public class CustomerServiceIT {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CustomerService customerService;
	
	private static String id = "1";
	private static String name = "Pista";
	
	@Test
	public void testSaveEmployee() {
		customerService.saveCustomer(id, name);	
		List<String> names = customerDao.getCustomers();
		assertEquals(List.of(name.toUpperCase()), names);
		
	}

}
