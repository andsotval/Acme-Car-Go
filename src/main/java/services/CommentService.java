
package services;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import domain.Actor;
import domain.Comment;
import domain.OfferOrRequest;
import repositories.CommentRepository;

@Service
@Transactional
public class CommentService {
	// Managed repository -----------------------------------------------------

	@Autowired
	private CommentRepository	commentRepository;

	// Supporting services ----------------------------------------------------
	@Autowired
	ActorService				actorService;
	@Autowired
	OfferOrRequestService		offerOrRequestService;

	// Validator -------------------------------------------------------------
	@Autowired
	private Validator			validator;


	// Constructors -----------------------------------------------------------

	public CommentService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------
	public Comment create() {
		final Comment res = new Comment();
		res.setMoment(new Date());
		return res;
	}

	public Collection<Comment> findAll() {
		Collection<Comment> result;

		result = this.commentRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Comment findOne(final int commentId) {
		Assert.isTrue(commentId != 0);

		Comment result;

		result = this.commentRepository.findOne(commentId);
		Assert.notNull(result);

		return result;
	}

	public Comment save(final Comment comment) {
		Assert.notNull(comment);

		Comment result;
		System.out.println("aqui llega");
		result = this.commentRepository.save(comment);
		System.out.println("Aqui tambien");
		System.out.println(result.getId() + "," + result.getTitle() + "," + result.getDescription());
		final OfferOrRequest offerOrRequest = this.offerOrRequestService.findOne(comment.getOfferOrRequest().getId());
		offerOrRequest.getComments().add(result);
		for (final Comment c : offerOrRequest.getComments())
			System.out.println(c.getId());
		return result;
	}

	public void delete(final Comment comment) {
		Assert.notNull(comment);
		Assert.isTrue(comment.getId() != 0);
		Assert.isTrue(this.commentRepository.exists(comment.getId()));

		this.commentRepository.delete(comment);
	}

	// Other business methods -------------------------------------------------
	public void banComment(final int commentId) {
		Assert.notNull(commentId);
		final Comment c = this.findOne(commentId);
		Assert.notNull(c);
		c.setIsBan(true);
	}
	public Comment createCommentByActor(final int actorId) {
		final Comment c = this.create();
		final Actor a = this.actorService.findOne(actorId);
		Assert.notNull(a);
		c.setActor(a);
		return c;
	}
	public Comment createCommentByOfferOrRequest(final int offerOrRequestId) {
		final Comment c = this.create();
		final OfferOrRequest a = this.offerOrRequestService.findOne(offerOrRequestId);
		Assert.notNull(a);
		c.setOfferOrRequest(a);
		return c;
	}

	public Comment reconstruct(final Comment comment, final Actor actor, final BindingResult binding) {
		Comment result;
		if (comment.getId() == 0)
			result = comment;
		else {
			result = this.commentRepository.findOne(comment.getId());
			result.setTitle(comment.getTitle());
			result.setDescription(comment.getDescription());
			result.setStars(comment.getStars());
			result.setActor(actor);
			this.validator.validate(result, binding);
		}
		return result;
	}

	public Comment reconstruct(final Comment comment, final OfferOrRequest offerOrRequest, final BindingResult binding) {
		Comment result;
		if (comment.getId() == 0)
			result = comment;
		else {
			result = this.commentRepository.findOne(comment.getId());
			result.setTitle(comment.getTitle());
			result.setDescription(comment.getDescription());
			result.setStars(comment.getStars());
			result.setOfferOrRequest(offerOrRequest);
			this.validator.validate(result, binding);
		}
		return result;
	}
}
