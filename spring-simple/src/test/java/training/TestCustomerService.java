package training;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
public class TestCustomerService {
	
	@Mock
	private CustomerDao customerDao;
	
	private CustomerService customerService;
	
	@Mock
	private ApplicationEventPublisher applicationEventPublisher;
	
	private static String id = "1";
	private static String name = "Pista";
	
	@Nested
	class WithTrue {
		
		@BeforeEach
		public void init() {
			customerService = new CustomerService(customerDao, applicationEventPublisher, true);
		}
		
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
	
	@Nested
	class WithFalse {
		
		@BeforeEach
		public void init() {
			customerService = new CustomerService(customerDao, applicationEventPublisher, false);
		}
		
		@Test
		public void testNullPointerExceptionSaveEmployee () {
			
			assertThrows(NullPointerException.class, () -> customerService.saveCustomer("", name));
		}
		
		@Test
		public void testSuccessSaveEmployee () {
			
			customerService.saveCustomer(id, name);
			
			verify(customerDao).saveCustomer(eq(id), eq(name));
			
		}
	}

}
