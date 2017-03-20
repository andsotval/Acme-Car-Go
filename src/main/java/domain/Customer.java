package domain;

import java.util.Collection;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Customer extends Actor {

	// Attributes

	// Constructor
	public Customer() {
		super();
	}

	// Getters and Setters

	// Relationships
	private Collection<OfferOrRequest> offers;
	private Collection<Application> applications;
	@NotNull
	@Valid
	@OneToMany(mappedBy="offer")
	public Collection<OfferOrRequest> getOffers() {
		return offers;
	}

	public void setOffers(Collection<OfferOrRequest> offers) {
		this.offers = offers;
	}
	@NotNull
	@Valid
	@OneToMany(mappedBy="customer")
	public Collection<Application> getApplications() {
		return applications;
	}

	public void setApplications(Collection<Application> applications) {
		this.applications = applications;
	}
}
