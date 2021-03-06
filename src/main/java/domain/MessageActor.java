package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class MessageActor extends DomainEntity {
	// Attributes
	private String title;
	private Date moment;
	private String text;
	private Collection<String> attachements;

	// Constructor
	public MessageActor() {
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
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@ElementCollection
	public Collection<String> getAttachements() {
		return attachements;
	}

	public void setAttachements(Collection<String> attachements) {
		this.attachements = attachements;
	}
	//Relationship
	private Actor receiver;
	private Actor sender;
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	public Actor getReceiver() {
		return receiver;
	}

	public void setReceiver(Actor receiver) {
		this.receiver = receiver;
	}
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	public Actor getSender() {
		return sender;
	}

	public void setSender(Actor sender) {
		this.sender = sender;
	}
}
