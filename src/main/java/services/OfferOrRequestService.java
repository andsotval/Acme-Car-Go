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
import domain.OfferOrRequest;

import repositories.OfferOrRequestRepository;

@Service
@Transactional
public class OfferOrRequestService {
	// Managed repository -----------------------------------------------------

	@Autowired
	private OfferOrRequestRepository offerOrRequestRepository;

	// Supporting services ----------------------------------------------------
	@Autowired
	private ApplicationService applicationService;
	@Autowired
	private CustomerService customerService;
	// Constructors -----------------------------------------------------------

	public OfferOrRequestService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------
	public OfferOrRequest create(){
		OfferOrRequest res= new OfferOrRequest();
		res.setApplications(new HashSet<Application>());
		res.setComments(new HashSet<Comment>());
		Customer c=customerService.findByPrincipal();
		Assert.notNull(c);
		res.setOffer(c);
		return res;
	}
	
	public Collection<OfferOrRequest> findAll() {
		Collection<OfferOrRequest> result;
		
		result = offerOrRequestRepository.findAll();
		Assert.notNull(result);
		
		return result;
	}

	public OfferOrRequest findOne(int offerOrRequestId) {
		Assert.isTrue(offerOrRequestId != 0);
		
		OfferOrRequest result;

		result = offerOrRequestRepository.findOne(offerOrRequestId);
		Assert.notNull(result);

		return result;
	}
	
	public OfferOrRequest save(OfferOrRequest offerOrRequest) {
		Assert.notNull(offerOrRequest);
		
		OfferOrRequest result;

		result = offerOrRequestRepository.save(offerOrRequest);
		
		return result;
	}	
	
	public void delete(OfferOrRequest offerOrRequest) {
		Assert.notNull(offerOrRequest);
		Assert.isTrue(offerOrRequest.getId() != 0);
		Assert.isTrue(offerOrRequestRepository.exists(offerOrRequest.getId()));		
		
		offerOrRequestRepository.delete(offerOrRequest);
	}

	// Other business methods -------------------------------------------------
	public Double getRatio(){
		return offerOrRequestRepository.getRatio();
	}
	public Double getAveragePerCustomer(){
		return offerOrRequestRepository.getAveragePerCustomer();
	}
	public Double getAverageApplicationsPerOfferOrRequest(){
		return offerOrRequestRepository.getAverageApplicationsPerOfferOrRequest();
	}
	public Collection<OfferOrRequest> getSearch(String text){
		return offerOrRequestRepository.getSearch(text);
	}
	public void applyOfferOrRequest(int offerOrRequestId){
		Assert.notNull(offerOrRequestId);
		OfferOrRequest o=findOne(offerOrRequestId);
		Assert.notNull(o);
		Application a=applicationService.create();
		o.getApplications().add(a);
		a.setRequest(o);
		applicationService.save(a);
	}
	public void banOfferOrRequest(int offerOrRequestId){
		Assert.notNull(offerOrRequestId);
		OfferOrRequest o=findOne(offerOrRequestId);
		Assert.notNull(o);
		o.setIsBan(true);
	}
}
