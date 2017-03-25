
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import security.UserAccount;

@Entity
@Access(AccessType.PROPERTY)
public abstract class Actor extends DomainEntity {

	// Attributes
	private String fullName;
	private String email;
	private String phone;

	// Constructor
	public Actor() {
		super();
	}

	// Getters and Setters
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



	// Relationships
	private Collection<MessageActor> senders;
	private Collection<MessageActor> receivers;
	private UserAccount userAccount;
	private Collection<Comment> comments;

	@NotNull
	@Valid
	@OneToMany(mappedBy = "sender")
	public Collection<MessageActor> getSenders() {
		return senders;
	}

	public void setSenders(Collection<MessageActor> senders) {
		this.senders = senders;
	}

	@NotNull
	@Valid
	@OneToMany(mappedBy = "receiver")
	public Collection<MessageActor> getReceivers() {
		return receivers;
	}

	public void setReceivers(Collection<MessageActor> receivers) {
		this.receivers = receivers;
	}

	@NotNull
	@Valid
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	@NotNull
	@Valid
	@OneToMany(mappedBy = "actor")
	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}
}
