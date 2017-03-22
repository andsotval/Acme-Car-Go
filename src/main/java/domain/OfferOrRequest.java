package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class OfferOrRequest extends DomainEntity {
	// Attributes
	private String title;
	private String description;
	private Date moment;
	private String originPlace;
	//private Coordinates originCoor;
	private String sourcePlace;
	//private Coordinates sourceCoor;
	private Collection<Comment> comments;
	private boolean isOffer;
	private boolean isBan;

	// Constructor
	public OfferOrRequest() {
		super();
	}

	// Getters and Setters
	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@NotBlank
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}
	@NotBlank
	public String getOriginPlace() {
		return originPlace;
	}

	public void setOriginPlace(String originPlace) {
		this.originPlace = originPlace;
	}
	/*@Valid
	@Column(name="originCoor")
	public Coordinates getOriginCoor() {
		return originCoor;
	}

	public void setOriginCoor(Coordinates originCoor) {
		this.originCoor = originCoor;
	}*/
	@NotBlank
	public String getSourcePlace() {
		return sourcePlace;
	}

	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	/*@Valid
	@Column(name="sourceCoor")
	public Coordinates getSourceCoor() {
		return sourceCoor;
	}

	public void setSourceCoor(Coordinates sourceCoor) {
		this.sourceCoor = sourceCoor;
	}*/
	@ElementCollection
	@Valid
	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

	public boolean getIsOffer() {
		return isOffer;
	}

	public void setIsOffer(boolean isOffer) {
		this.isOffer = isOffer;
	}

	public boolean getIsBan() {
		return isBan;
	}

	public void setIsBan(boolean isBan) {
		this.isBan = isBan;
	}
	//Relationship
	private Customer offer;
	private Collection<Application> applications;
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	public Customer getOffer() {
		return offer;
	}

	public void setOffer(Customer offer) {
		this.offer = offer;
	}
	@NotNull
	@Valid
	@OneToMany(mappedBy="request")
	public Collection<Application> getApplications() {
		return applications;
	}

	public void setApplications(Collection<Application> applications) {
		this.applications = applications;
	}
}
