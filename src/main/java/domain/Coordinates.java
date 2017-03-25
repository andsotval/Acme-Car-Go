package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Coordinates extends DomainEntity {

	// Attributes
	private double longitude;
	private double latitude;

	// Constructor
	public Coordinates(){
		super();
	}

	//Getters and Setters
	@NotNull
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	@NotNull
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	//Relationship
}
