package controllers.customer;

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
import domain.OfferOrRequest;
import services.OfferOrRequestService;

@Controller
@RequestMapping("/offerOrRequest/customer")
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

	// Apply ---------------------------------------------------------------
	@RequestMapping("/apply")
	public ModelAndView apply(@RequestParam int offerOrRequestId) {
		ModelAndView result;
		offerOrRequestService.applyOfferOrRequest(offerOrRequestId);
		Collection<OfferOrRequest> offersAndRequests = offerOrRequestService.getSearch("");
		result = new ModelAndView("redirect:list.do");
		result.addObject("offerOrRequests", offersAndRequests);
		return result;
	}

	// Ban ---------------------------------------------------------------
	@RequestMapping("/ban")
	public ModelAndView ban(@RequestParam int offerOrRequestId) {
		ModelAndView result;
		offerOrRequestService.banOfferOrRequest(offerOrRequestId);
		Collection<OfferOrRequest> offersAndRequests = offerOrRequestService.getSearch("");
		result = new ModelAndView("offerOrRequest/list");
		result.addObject("offerOrRequests", offersAndRequests);
		return result;
	}
	// Creation ----------------------------------------------------------------

		@RequestMapping(value = "/register", method = RequestMethod.GET)
		public ModelAndView register() {
			ModelAndView result;
			OfferOrRequest offerOrRequest=offerOrRequestService.create();
			result=new ModelAndView("offerOrRequest/edit");
			result.addObject("offerOrRequest",offerOrRequest);
			return result;

		}
		// Register ----------------------------------------------------------------
			@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
			public ModelAndView save(@Valid OfferOrRequest offerOrRequest, BindingResult binding) {
				ModelAndView result;
				if(binding.hasErrors()){
					System.out.println(binding);
					result=new ModelAndView("offerOrRequest/edit");
					result.addObject("offerOrRequest",offerOrRequest);
				}
				else{
					try{
						offerOrRequestService.save(offerOrRequest);
						result = new ModelAndView("redirect:/");
					}catch(Throwable oops){
						result=new ModelAndView("offerOrRequest/edit");
						result.addObject("offerOrRequest",offerOrRequest);
						result.addObject("message","offerOrRequest.commit.error");
					}
				}
				return result;
			}


}
