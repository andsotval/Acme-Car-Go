package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Banner extends DomainEntity {
	// Attributes
	private String url;

	// Constructor
	public Banner() {
		super();
	}

	// Getters and Setters
	@URL
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	// RelationShip
}
