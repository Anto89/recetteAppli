package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.RecetteDao;

@Controller
@RequestMapping(value = "/recettes")
public class RecetteController {
	@Autowired
	RecetteDao recetteDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView displayRecettes() {
		ModelAndView mav = new ModelAndView("recetteIndex");
		mav.addObject("recettes", recetteDao.getAll());
		return mav;
	}
}
