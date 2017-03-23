package services;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Application;
import domain.Comment;
import domain.OfferOrRequest;

import repositories.OfferOrRequestRepository;

@Service
@Transactional
public class OfferOrRequestService {
	// Managed repository -----------------------------------------------------

	@Autowired
	private OfferOrRequestRepository offerOrRequestRepository;

	// Supporting services ----------------------------------------------------

	// Constructors -----------------------------------------------------------

	public OfferOrRequestService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------
	public OfferOrRequest create(){
		OfferOrRequest res= new OfferOrRequest();
		res.setApplications(new HashSet<Application>());
		res.setComments(new HashSet<Comment>());
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
}
