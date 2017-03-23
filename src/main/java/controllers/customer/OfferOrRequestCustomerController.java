package controllers.customer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.OfferOrRequest;
import services.OfferOrRequestService;

@Controller
@RequestMapping("/customer/offerOrRequest")
public class OfferOrRequestCustomerController extends AbstractController {
	// Constructors -----------------------------------------------------------

	public OfferOrRequestCustomerController() {
		super();
	}

	// Services----------------------------------------
	@Autowired
	OfferOrRequestService offerOrRequestService;

	// List ---------------------------------------------------------------
	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView result;
		Collection<OfferOrRequest> offersAndRequests = offerOrRequestService.findAll();
		result = new ModelAndView("offerOrRequest/list");
		result.addObject("offerOrRequests", offersAndRequests);
		return result;
	}

	// Search ---------------------------------------------------------------
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String text) {
		ModelAndView result;
		Collection<OfferOrRequest> offersAndRequests = offerOrRequestService.getSearch(text);
		result = new ModelAndView("offerOrRequest/list");
		result.addObject("offerOrRequests", offersAndRequests);
		return result;
	}

}
