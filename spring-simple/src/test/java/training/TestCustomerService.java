package training;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
public class TestCustomerService {
	
	@Mock
	private CustomerDao customerDao;
	
	@InjectMocks
	private CustomerService customerService;
	
	private static String id = "1";
	private static String name = "Pista";
	
	@Test
	public void testNullPointerExceptionSaveEmployee () {
		
		assertThrows(NullPointerException.class, () -> customerService.saveCustomer("", name));
	}
	
	@Test
	public void testSuccessSaveEmployee () {
		
		customerService.saveCustomer(id, name);
		
		verify(customerDao).saveCustomer(eq(id), eq(name.toUpperCase()));
		
	}

}
