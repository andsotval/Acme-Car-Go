
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Comment extends DomainEntity{

	// Attributes
	private String title;
	private Date moment;
	private String description;
	private int stars;
	private boolean isBan;

	// Constructor
	public Comment() {
		super();
	}

	// Getters and Setters
	@NotBlank
	@SafeHtml
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Past
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
	@SafeHtml
	public String getDescription() {
		return description;
	}

	public void setDescription(String text) {
		this.description = text;
	}

	@Range(min = 0, max = 5)
	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public boolean getIsBan() {
		return isBan;
	}

	public void setIsBan(boolean isBan) {
		this.isBan = isBan;
	}
	// Relationships
	private Actor actor;
	private OfferOrRequest offerOrRequest;
	
	@Valid
	@ManyToOne(optional=true)
	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}
	@Valid
	@ManyToOne(optional=true)
	public OfferOrRequest getOfferOrRequest() {
		return offerOrRequest;
	}

	public void setOfferOrRequest(OfferOrRequest offerOrRequest) {
		this.offerOrRequest = offerOrRequest;
	}
	
}
