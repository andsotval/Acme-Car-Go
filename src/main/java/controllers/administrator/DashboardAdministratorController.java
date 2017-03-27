package controllers.administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import services.ActorService;
import services.CommentService;
import services.CustomerService;
import services.MessageService;
import services.OfferOrRequestService;

@Controller
@RequestMapping("/administrator")
public class DashboardAdministratorController extends AbstractController {
	// Constructors -----------------------------------------------------------

	public DashboardAdministratorController() {
		super();
	}
	// Services --------------------------------------------------------------
	@Autowired
	OfferOrRequestService offerOrRequestService;
	@Autowired
	ActorService actorService;
	@Autowired
	MessageService messageService;
	@Autowired
	CustomerService customerService;
	// Dashboard ---------------------------------------------------------------

	@RequestMapping("/dashboard")
	public ModelAndView dashboard() {
		ModelAndView result;

		result = new ModelAndView("administrator/dashboard");
		result.addObject("valor1", offerOrRequestService.getRatio());
		result.addObject("valor2", offerOrRequestService.getAveragePerCustomer());
		result.addObject("valor3", offerOrRequestService.getAverageApplicationsPerOfferOrRequest());
		result.addObject("valor4", customerService.getCustomerMoreApplicationsAccepted());
		result.addObject("valor5", customerService.getCustomerMoreApplicationsDenied());
		result.addObject("valor6", actorService.getActorsAverageCommentsAll());
		result.addObject("valor7", actorService.getActorsAverageComments());
		result.addObject("valor8", actorService.getActorsMoreCommentsByAverage());
		result.addObject("valor9", messageService.getMessageStatsSent());
		result.addObject("valor10", messageService.getMessageStatsReceived());
		result.addObject("valor11", messageService.getActorMoreSent());
		result.addObject("valor12", messageService.getActorMoreReceived());
		return result;
	}

}
