package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Application extends DomainEntity {
	// Attributes
	private EnumApplication application;

	// Constructor
	public Application() {
		super();
	}

	// Getters and Setters
	public EnumApplication getApplication() {
		return application;
	}

	public void setApplication(EnumApplication application) {
		this.application = application;
	}
	// Relationship
	private Customer customer;
	private OfferOrRequest request;
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public OfferOrRequest getRequest() {
		return request;
	}

	public void setRequest(OfferOrRequest request) {
		this.request = request;
	}
}
