
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
@Access(AccessType.PROPERTY)
public class Comment {

	// Attributes
	private String title;
	private Date moment;
	private String desciption;
	private int stars;
	private boolean isBan;

	// Constructor
	public Comment() {
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
	public String getDescription() {
		return desciption;
	}

	public void setDescription(String text) {
		this.desciption = text;
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
}
