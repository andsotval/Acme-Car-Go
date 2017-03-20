
package domain;

import java.util.Collection;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import security.UserAccount;

@Entity
@Access(AccessType.PROPERTY)
public abstract class Actor extends DomainEntity {

	//Attributes
	private String fullName;
	private String email;
	private String phone;
	private Collection<Comment> comments;


	//Constructor
	public Actor() {
		super();
	}


	//Getters and Setters
	@NotBlank
	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Email
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	@ElementCollection
	@Valid
	public Collection<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	//Relationships
	private Collection<Message> senders;
	private Collection<Message> receivers;
	
	@NotNull
	@Valid
	@OneToMany(mappedBy="sender")
	public Collection<Message> getSenders() {
		return senders;
	}


	public void setSenders(Collection<Message> senders) {
		this.senders = senders;
	}
	@NotNull
	@Valid
	@OneToMany(mappedBy="receiver")
	public Collection<Message> getReceivers() {
		return receivers;
	}


	public void setReceivers(Collection<Message> receivers) {
		this.receivers = receivers;
	}
	

}
