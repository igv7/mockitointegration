package mockitointegration.teststubs;

public class SimpleCustomerService implements CustomerService {

	CustomerRepository customerRepository;

	SimpleCustomerService(CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer getCustomerById(long id) {
		return customerRepository.getCustomerById(id);
		
	}
}
