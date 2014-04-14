package controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestServlet {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView("test");
		mav.addObject("message", "Test Spring MVC");
		return mav;
	}

	@RequestMapping(value = "/testJSON", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Message testJSON() {
		return new Message("Spring Exposed Resource");
	}

	public class Message implements Serializable {
		private static final long serialVersionUID = 8506659712795536420L;
		private String message;

		public Message(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
}
