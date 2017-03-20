package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Administrator;

import repositories.AdministratorRepository;

@Service
@Transactional
public class AdministratorService {
	// Managed repository -----------------------------------------------------

	@Autowired
	private AdministratorRepository administratorRepository;

	// Supporting services ----------------------------------------------------

	// Constructors -----------------------------------------------------------

	public AdministratorService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------
	public Administrator create(){
		Administrator res= new Administrator();
		return res;
	}
	
	public Collection<Administrator> findAll() {
		Collection<Administrator> result;
		
		result = administratorRepository.findAll();
		Assert.notNull(result);
		
		return result;
	}

	public Administrator findOne(int administratorId) {
		Assert.isTrue(administratorId != 0);
		
		Administrator result;

		result = administratorRepository.findOne(administratorId);
		Assert.notNull(result);

		return result;
	}
	
	public Administrator save(Administrator administrator) {
		Assert.notNull(administrator);
		
		Administrator result;

		result = administratorRepository.save(administrator);
		
		return result;
	}	
	
	public void delete(Administrator administrator) {
		Assert.notNull(administrator);
		Assert.isTrue(administrator.getId() != 0);
		Assert.isTrue(administratorRepository.exists(administrator.getId()));		
		
		administratorRepository.delete(administrator);
	}

	// Other business methods -------------------------------------------------
}
