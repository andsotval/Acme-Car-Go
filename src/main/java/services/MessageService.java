package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Message;

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
	public Message create(){
		Message res= new Message();
		return res;
	}
	
	public Collection<Message> findAll() {
		Collection<Message> result;
		
		result = messageRepository.findAll();
		Assert.notNull(result);
		
		return result;
	}

	public Message findOne(int messageId) {
		Assert.isTrue(messageId != 0);
		
		Message result;

		result = messageRepository.findOne(messageId);
		Assert.notNull(result);

		return result;
	}
	
	public Message save(Message message) {
		Assert.notNull(message);
		
		Message result;

		result = messageRepository.save(message);
		
		return result;
	}	
	
	public void delete(Message message) {
		Assert.notNull(message);
		Assert.isTrue(message.getId() != 0);
		Assert.isTrue(messageRepository.exists(message.getId()));		
		
		messageRepository.delete(message);
	}

	// Other business methods -------------------------------------------------
}
