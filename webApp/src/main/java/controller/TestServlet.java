package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/test")
public class TestServlet {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView("test");
		mav.addObject("message", "Test réussi");
		return mav;
	}
}
