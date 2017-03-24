/* CustomerController.java
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Customer;
import security.Authority;
import services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController extends AbstractController {

	// Constructors -----------------------------------------------------------

	public CustomerController() {
		super();
	}
	//Services
	@Autowired
	CustomerService customerService;
	// Creation ----------------------------------------------------------------

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView result;
        Customer customer=customerService.create();
		result=new ModelAndView("customer/edit");
		result.addObject("customer",customer);
		return result;

	}
	// Register ----------------------------------------------------------------
		@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
		public ModelAndView save(@Valid Customer customer, BindingResult binding) {
			ModelAndView result;
			if(binding.hasErrors()){
				System.out.println(binding);
				result=new ModelAndView("customer/edit");
				result.addObject("customer",customer);
			}
			else{
				try{
					customerService.save(customer);
					result = new ModelAndView("redirect:/");
				}catch(Throwable oops){
					result=new ModelAndView("customer/edit");
					result.addObject("customer",customer);
					result.addObject("message","customer.commit.error");
				}
			}
			return result;
		}

}