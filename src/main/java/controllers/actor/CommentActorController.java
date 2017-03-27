
package controllers.actor;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Actor;
import domain.Comment;
import domain.OfferOrRequest;
import services.ActorService;
import services.CommentService;
import services.OfferOrRequestService;

@Controller
@RequestMapping("/comment")
public class CommentActorController extends AbstractController {
	// Constructors -----------------------------------------------------------

	public CommentActorController() {
		super();
	}


	// Services----------------------------------------
	@Autowired
	CommentService			commentService;

	@Autowired
	ActorService			actorService;

	@Autowired
	OfferOrRequestService	offerOrRequestService;


	// List ---------------------------------------------------------------
	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView result;
		final Collection<Comment> comments = this.commentService.findAll();
		result = new ModelAndView("comment/list");
		result.addObject("comments", comments);
		return result;
	}

	// Ban ---------------------------------------------------------------
	@RequestMapping("/ban")
	public ModelAndView ban(@RequestParam final int commentId) {
		ModelAndView result;
		this.commentService.banComment(commentId);
		final Collection<Comment> comments = this.commentService.findAll();
		result = new ModelAndView("comment/list");
		result.addObject("comments", comments);
		return result;
	}
	// Creation ----------------------------------------------------------------

	@RequestMapping(value = "/registerByActor", method = RequestMethod.GET)
	public ModelAndView registerByActor(@RequestParam final int actorId) {
		ModelAndView result;
		final Comment comment = this.commentService.create();
		final Actor actor = this.actorService.findOne(actorId);
		result = new ModelAndView("comment/edit");
		result.addObject("comment", comment);
		result.addObject("actor", actor);
		return result;

	}
	// Creation ----------------------------------------------------------------

	@RequestMapping(value = "/registerByOfferOrRequest", method = RequestMethod.GET)
	public ModelAndView registerByOfferOrRequest(@RequestParam final int offerOrRequestId) {
		ModelAndView result;
		final Comment comment = this.commentService.create();
		Assert.notNull(this.offerOrRequestService.findOne(offerOrRequestId));
		final OfferOrRequest offerOrRequest = this.offerOrRequestService.findOne(offerOrRequestId);
		if (offerOrRequest == null)
			result = new ModelAndView("/offerOrRequest/customer/list");
		else {
			result = new ModelAndView("comment/editOfferOrRequest");
			result.addObject("comment", comment);
			result.addObject("offerOrRequest", offerOrRequest);

		}
		return result;

	}

	// Register ----------------------------------------------------------------
	@RequestMapping(value = "/{actor}/registerActor", method = RequestMethod.POST, params = "save")
	public ModelAndView save(Comment comment, final BindingResult binding, @PathVariable final Actor actor) {
		ModelAndView result;

		comment = this.commentService.reconstruct(comment, actor, binding);
		if (binding.hasErrors()) {
			System.out.println(binding);
			result = new ModelAndView("comment/edit");
			result.addObject("comment", comment);
		} else
			try {
				this.commentService.save(comment);
				result = new ModelAndView("redirect:/");
			} catch (final Throwable oops) {
				result = new ModelAndView("comment/edit");
				result.addObject("comment", comment);
				result.addObject("message", "comment.commit.error");
			}
		return result;
	}

	// Register ----------------------------------------------------------------
	@RequestMapping(value = "/{offerOrRequest}/registerOfferOrRequest", method = RequestMethod.POST, params = "save")
	public ModelAndView save(Comment comment, final BindingResult binding, @PathVariable final OfferOrRequest offerOrRequest) {
		ModelAndView result;
		comment = this.commentService.reconstruct(comment, offerOrRequest, binding);
		if (binding.hasErrors()) {
			System.out.println(binding);
			result = new ModelAndView("comment/edit");
			result.addObject("comment", comment);
		} else
			try {
				this.commentService.save(comment);
				System.out.println("todo ok");
				result = new ModelAndView("redirect:/");
			} catch (final Throwable oops) {
				result = new ModelAndView("comment/edit");
				result.addObject("comment", comment);
				result.addObject("message", "comment.commit.error");
			}
		return result;
	}

}
