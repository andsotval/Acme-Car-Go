package controllers.actor;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Application;
import domain.Message;
import services.ActorService;
import services.ApplicationService;
import services.CustomerService;
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

		// List Message Received ---------------------------------------------------------------
		@RequestMapping("/receivers")
		public ModelAndView receivers() {
			ModelAndView result;
			Collection<Message> messages = actorService.findByPrincipal().getReceivers();
			result = new ModelAndView("message/list");
			result.addObject("messages", messages);
			return result;
		}
		// List Message Sended ---------------------------------------------------------------
				@RequestMapping("/senders")
				public ModelAndView senders() {
					ModelAndView result;
					Collection<Message> messages = actorService.findByPrincipal().getSenders();
					result = new ModelAndView("message/list");
					result.addObject("messages", messages);
					return result;
				}

}
