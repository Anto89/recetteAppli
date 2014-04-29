package controller;

import java.util.List;

import model.Recette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import dao.RecetteDao;
import dto.RecetteDto;

@Controller
public class RecetteController {
	@Autowired
	RecetteDao recetteDao;

	@RequestMapping(method = RequestMethod.GET, value = "/recettes", produces = "application/json")
	public @ResponseBody List<Recette> getRecettes() {
		return recetteDao.getAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/recettes", consumes = "application/json")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void saveRecette(@RequestBody RecetteDto recetteDto) {
		recetteDao.persist(recetteDto);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/recettes/{id}", produces = "application/json")
	public @ResponseBody RecetteDto getRecette(@PathVariable Long id) {
		return recetteDao.getById(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/recettes/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteRecette(@PathVariable Long id) {
		recetteDao.remove(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/recettes/{id}", consumes = "application/json")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void updateRecette(@RequestBody Recette recette) {
		recetteDao.update(recette);
	}

//	@RequestMapping(method = RequestMethod.GET, value = "/recettes/{id}/ingredients", produces = "application/json")
//	public @ResponseBody Map<String, BigDecimal> getIngredientsForRecette(@PathVariable Long id) {
//		return recetteDao.getIngredients(id);
//	}
}
