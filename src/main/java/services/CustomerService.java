package services;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Application;
import domain.Comment;
import domain.Customer;
import domain.MessageActor;
import domain.OfferOrRequest;
import repositories.CustomerRepository;
import security.LoginService;
import security.UserAccount;
import security.UserAccountService;

@Service
@Transactional
public class CustomerService {
	// Managed repository -----------------------------------------------------

	@Autowired
	private CustomerRepository customerRepository;

	// Supporting services ----------------------------------------------------
	@Autowired
	private UserAccountService userAccountService;
	// Constructors -----------------------------------------------------------

	public CustomerService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------
	public Customer create(){
		Customer res= new Customer();
		res.setComments(new HashSet<Comment>());
		res.setReceivers(new HashSet<MessageActor>());
		res.setSenders(new HashSet<MessageActor>());
		res.setApplications(new HashSet<Application>());
		res.setOffers(new HashSet<OfferOrRequest>());
		
		res.setUserAccount(userAccountService.create("CUSTOMER"));
		return res;
	}
	
	public Collection<Customer> findAll() {
		Collection<Customer> result;
		
		result = customerRepository.findAll();
		Assert.notNull(result);
		
		return result;
	}

	public Customer findOne(int customerId) {
		Assert.isTrue(customerId != 0);
		
		Customer result;

		result = customerRepository.findOne(customerId);
		Assert.notNull(result);

		return result;
	}
	
	public Customer save(Customer customer) {
		Assert.notNull(customer);
		
		Customer result;

		result = customerRepository.save(customer);
		
		return result;
	}	
	
	public void delete(Customer customer) {
		Assert.notNull(customer);
		Assert.isTrue(customer.getId() != 0);
		Assert.isTrue(customerRepository.exists(customer.getId()));		
		
		customerRepository.delete(customer);
	}

	// Other business methods -------------------------------------------------
	
	public Customer getCustomerMoreApplicationsAccepted(){
		return customerRepository.getCustomerMoreApplicationsAccepted();
	}
	public Customer getCustomerMoreApplicationsDenied(){
		return customerRepository.getCustomerMoreApplicationsDenied();
	}
	public Customer findByUserAccount(UserAccount userAccount) {
		Assert.notNull(userAccount);

		Customer result;
		result = customerRepository.findByUserAccount(userAccount);
		return result;
	}
	public Customer findByPrincipal() {
		Customer result;
		UserAccount userAccount;
		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}
}
