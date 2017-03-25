package services;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Actor;
import domain.MessageActor;

import repositories.MessageRepository;

@Service
@Transactional
public class MessageService {
	// Managed repository -----------------------------------------------------

	@Autowired
	private MessageRepository messageRepository;

	// Supporting services ----------------------------------------------------

	// Constructors -----------------------------------------------------------

	public MessageService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------
	public MessageActor create(){
		MessageActor res= new MessageActor();
		res.setAttachements(new HashSet<String>());
		res.setMoment(new Date());
		return res;
	}
	
	public Collection<MessageActor> findAll() {
		Collection<MessageActor> result;
		
		result = messageRepository.findAll();
		Assert.notNull(result);
		
		return result;
	}

	public MessageActor findOne(int messageId) {
		Assert.isTrue(messageId != 0);
		
		MessageActor result;

		result = messageRepository.findOne(messageId);
		Assert.notNull(result);

		return result;
	}
	
	public MessageActor save(MessageActor messageActor) {
		Assert.notNull(messageActor);
		
		MessageActor result;

		result = messageRepository.save(messageActor);
		
		return result;
	}	
	
	public void delete(MessageActor messageActor) {
		Assert.notNull(messageActor);
		Assert.isTrue(messageActor.getId() != 0);
		Assert.isTrue(messageRepository.exists(messageActor.getId()));		
		
		messageRepository.delete(messageActor);
	}

	// Other business methods -------------------------------------------------
	public Double[] getMessageStatsSent(){
		return messageRepository.getMessageStatsSent();
	}
	public Double[] getMessageStatsReceived(){
		return messageRepository.getMessageStatsReceived();
	}
	public Actor getActorMoreSent(){
		return messageRepository.getActorMoreSent();
	}
	public Actor getActorMoreReceived(){
		return messageRepository.getActorMoreReceived();
	}
	
}
