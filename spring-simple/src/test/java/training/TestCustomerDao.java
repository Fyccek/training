package training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TestCustomerDao {
	
	@Test
	public void testSuccessSaveCustomer() {
		
		CustomerDao customerDao = new CustomerDao();
		
		customerDao.saveCustomer("1", "Pista");
		assertEquals(List.of("Pista"), customerDao.getCustomers());
	}
}
