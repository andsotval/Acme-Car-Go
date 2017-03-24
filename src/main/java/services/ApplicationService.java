package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Application;
import domain.EnumApplication;
import repositories.ApplicationRepository;

@Service
@Transactional
public class ApplicationService {
	// Managed repository -----------------------------------------------------

	@Autowired
	private ApplicationRepository applicationRepository;

	// Supporting services ----------------------------------------------------
	@Autowired
	private CustomerService customerService;
	// Constructors -----------------------------------------------------------

	public ApplicationService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------
	public Application create(){
		Application res= new Application();
		res.setApplication(EnumApplication.PENDING);
		res.setCustomer(customerService.findByPrincipal());
		return res;
	}
	
	public Collection<Application> findAll() {
		Collection<Application> result;
		
		result = applicationRepository.findAll();
		Assert.notNull(result);
		
		return result;
	}

	public Application findOne(int applicationId) {
		Assert.isTrue(applicationId != 0);
		
		Application result;

		result = applicationRepository.findOne(applicationId);
		Assert.notNull(result);

		return result;
	}
	
	public Application save(Application application) {
		Assert.notNull(application);
		
		Application result;

		result = applicationRepository.save(application);
		
		return result;
	}	
	
	public void delete(Application application) {
		Assert.notNull(application);
		Assert.isTrue(application.getId() != 0);
		Assert.isTrue(applicationRepository.exists(application.getId()));		
		
		applicationRepository.delete(application);
	}

	// Other business methods -------------------------------------------------
	public void acceptApplication(int applicationId){
		Assert.notNull(applicationId);
		Application a=findOne(applicationId);
		Assert.notNull(a);
		a.setApplication(EnumApplication.ACCEPTED);
	}
	public void deniedApplication(int applicationId){
		Assert.notNull(applicationId);
		Application a=findOne(applicationId);
		Assert.notNull(a);
		a.setApplication(EnumApplication.DENIED);
	}
}
