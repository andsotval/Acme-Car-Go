package services;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Actor;
import domain.Comment;
import domain.OfferOrRequest;
import repositories.CommentRepository;

@Service
@Transactional
public class CommentService {
	// Managed repository -----------------------------------------------------

	@Autowired
	private CommentRepository commentRepository;

	// Supporting services ----------------------------------------------------
	@Autowired
	ActorService actorService;
	@Autowired
	OfferOrRequestService offerOrRequestService;

	// Constructors -----------------------------------------------------------

	public CommentService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------
	public Comment create(){
		Comment res= new Comment();
		res.setMoment(new Date());
		return res;
	}
	
	public Collection<Comment> findAll() {
		Collection<Comment> result;
		
		result = commentRepository.findAll();
		Assert.notNull(result);
		
		return result;
	}

	public Comment findOne(int commentId) {
		Assert.isTrue(commentId != 0);
		
		Comment result;

		result = commentRepository.findOne(commentId);
		Assert.notNull(result);

		return result;
	}
	
	public Comment save(Comment comment) {
		Assert.notNull(comment);
		
		Comment result;

		result = commentRepository.save(comment);
		
		return result;
	}	
	
	public void delete(Comment comment) {
		Assert.notNull(comment);
		Assert.isTrue(comment.getId() != 0);
		Assert.isTrue(commentRepository.exists(comment.getId()));		
		
		commentRepository.delete(comment);
	}

	// Other business methods -------------------------------------------------
	public void banComment(int commentId){
		Assert.notNull(commentId);
		Comment c=findOne(commentId);
		Assert.notNull(c);
		c.setIsBan(true);
	}
	public Comment createCommentByActor(int actorId){
		Comment c= create();
		Actor a=actorService.findOne(actorId);
		Assert.notNull(a);
		c.setActor(a);
		return c;
	}
	public Comment createCommentByOfferOrRequest(int offerOrRequestId){
		Comment c= create();
		OfferOrRequest a=offerOrRequestService.findOne(offerOrRequestId);
		Assert.notNull(a);
		c.setOfferOrRequest(a);
		return c;
	}
}
