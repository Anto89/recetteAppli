package controller;

import java.util.List;

import model.Ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.IngredientDao;

@Controller
public class IngredientController {
	@Autowired
	IngredientDao ingredientDao;

	@RequestMapping(method = RequestMethod.GET, value = "/ingredients", produces = "application/json")
	public @ResponseBody
	List<Ingredient> getIngredients() {
		return ingredientDao.getAll();
	}
}
