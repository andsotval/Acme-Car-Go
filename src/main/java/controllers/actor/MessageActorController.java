package controllers.actor;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Actor;
import domain.Application;
import domain.Comment;
import domain.MessageActor;
import services.ActorService;
import services.ApplicationService;
import services.CustomerService;
import services.MessageService;

@Controller
@RequestMapping("/message/actor")
public class MessageActorController extends AbstractController {
	// Constructors -----------------------------------------------------------

	public MessageActorController() {
		super();
	}

	// Services----------------------------------------
	@Autowired
	ActorService actorService;
	@Autowired
	MessageService messageService;

	// List Message Received
	// ---------------------------------------------------------------
	@RequestMapping("/receivers")
	public ModelAndView receivers() {
		ModelAndView result;
		Collection<MessageActor> messageActors = actorService.findByPrincipal().getReceivers();
		result = new ModelAndView("message/list");
		result.addObject("messages", messageActors);
		return result;
	}

	// List Message Sended
	// ---------------------------------------------------------------
	@RequestMapping("/senders")
	public ModelAndView senders() {
		ModelAndView result;
		Collection<MessageActor> messageActors = actorService.findByPrincipal().getSenders();
		result = new ModelAndView("message/list");
		result.addObject("messages", messageActors);
		return result;
	}
	// Creation ----------------------------------------------------------------

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(@RequestParam int actorId) {
		ModelAndView result;
		MessageActor messageActor = messageService.create();
		result = new ModelAndView("message/edit");
		result.addObject("messageActor", messageActor);
		return result;

	}

	// Register ----------------------------------------------------------------
	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid MessageActor messageActor, BindingResult binding) {
		ModelAndView result;
		if (binding.hasErrors()) {
			System.out.println(binding);
			result = new ModelAndView("message/edit");
			result.addObject("messageActor", messageActor);
		} else {
			try {
				messageService.save(messageActor);
				result = new ModelAndView("redirect:/");
			} catch (Throwable oops) {
				result = new ModelAndView("message/edit");
				result.addObject("messageActor", messageActor);
				result.addObject("message", "comment.commit.error");
			}
		}
		return result;
	}

}
