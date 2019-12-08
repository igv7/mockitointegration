package mockitointegration.teststubs;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

import mockitointegration.teststubs.Customer;
import mockitointegration.teststubs.CustomerNotFoundException;
import mockitointegration.teststubs.CustomerRepository;
import mockitointegration.teststubs.CustomerService;
import mockitointegration.teststubs.SimpleCustomerService;

class SaboteurDemo {

	@Test
	public void testInvalidCustomer() {

	  Customer customer = new Customer();
	  CustomerRepository customerRepository = mock(CustomerRepository.class);

	  when(customerRepository.getCustomerById(anyLong()))
	    					 .thenThrow(new CustomerNotFoundException());

	  CustomerService customerService = new SimpleCustomerService(customerRepository);
	  assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomerById(customer.getId()));
	}
}
