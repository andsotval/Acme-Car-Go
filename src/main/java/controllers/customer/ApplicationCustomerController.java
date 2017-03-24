package controllers.customer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Application;
import services.ApplicationService;
import services.CustomerService;

@Controller
@RequestMapping("/application/customer")
public class ApplicationCustomerController extends AbstractController {
	// Constructors -----------------------------------------------------------

	public ApplicationCustomerController() {
		super();
	}

	// Services----------------------------------------
	@Autowired
	ApplicationService applicationService;
	@Autowired
	CustomerService customerService;

	// List ---------------------------------------------------------------
	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView result;
		Collection<Application> applications = customerService.findByPrincipal().getApplications();
		result = new ModelAndView("application/list");
		result.addObject("applications", applications);
		return result;
	}

}
