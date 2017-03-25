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
import domain.Comment;
import domain.Comment;
import services.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentActorController extends AbstractController {
	// Constructors -----------------------------------------------------------

	public CommentActorController() {
		super();
	}

	// Services----------------------------------------
	@Autowired
	CommentService commentService;

	// List ---------------------------------------------------------------
	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView result;
		Collection<Comment> comments = commentService.findAll();
		result = new ModelAndView("comment/list");
		result.addObject("comments", comments);
		return result;
	}

	// Ban ---------------------------------------------------------------
	@RequestMapping("/ban")
	public ModelAndView ban(@RequestParam int commentId) {
		ModelAndView result;
		commentService.banComment(commentId);
		Collection<Comment> comments = commentService.findAll();
		result = new ModelAndView("comment/list");
		result.addObject("comments", comments);
		return result;
	}
	// Creation ----------------------------------------------------------------

	@RequestMapping(value = "/registerByActor", method = RequestMethod.GET)
	public ModelAndView registerByActor(@RequestParam int actorId) {
		ModelAndView result;
		Comment comment = commentService.createCommentByActor(actorId);
		result = new ModelAndView("comment/edit");
		result.addObject("comment", comment);
		return result;

	}
	// Creation ----------------------------------------------------------------

		@RequestMapping(value = "/registerByOfferOrRequest", method = RequestMethod.GET)
		public ModelAndView registerByOfferOrRequest(@RequestParam int offerOrRequestId) {
			ModelAndView result;
			Comment comment = commentService.createCommentByOfferOrRequest(offerOrRequestId);
			result = new ModelAndView("comment/edit");
			result.addObject("comment", comment);
			return result;

		}

	// Register ----------------------------------------------------------------
	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid Comment comment, BindingResult binding) {
		ModelAndView result;
		if (binding.hasErrors()) {
			System.out.println(binding);
			result = new ModelAndView("comment/edit");
			result.addObject("comment", comment);
		} else {
			try {
				commentService.save(comment);
				result = new ModelAndView("redirect:/");
			} catch (Throwable oops) {
				result = new ModelAndView("comment/edit");
				result.addObject("comment", comment);
				result.addObject("message", "comment.commit.error");
			}
		}
		return result;
	}

}
