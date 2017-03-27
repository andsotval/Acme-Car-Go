
package controllers.administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Banner;
import forms.BannerForm;
import services.BannerService;

@Controller
@RequestMapping("/banner/administrator")
public class BannerAdministratorController extends AbstractController {
	// Constructors -----------------------------------------------------------

	public BannerAdministratorController() {
		super();
	}


	// Services
	@Autowired
	BannerService bannerService;
	// Edit ----------------------------------------------------------------


	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit() {
		ModelAndView result;
		final Banner banner = this.bannerService.getOnlyBanner();
		result = new ModelAndView("banner/edit");
		result.addObject("banner", banner);
		return result;

	}

	// Register ----------------------------------------------------------------
	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView save(final BannerForm bannerForm, final BindingResult binding) {
		ModelAndView result;
		final Banner banner;

		banner = this.bannerService.reconstruct(bannerForm, binding);
		if (binding.hasErrors()) {
			System.out.println(binding);
			result = new ModelAndView("banner/edit");
			result.addObject("banner", banner);
		} else
			try {
				this.bannerService.save(banner);
				result = new ModelAndView("redirect:/");
			} catch (final Throwable oops) {
				result = new ModelAndView("banner/edit");
				result.addObject("banner", banner);
				result.addObject("message", "banner.commit.error");
			}
		return result;
	}
}
