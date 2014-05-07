package dao;

import java.util.List;

import model.Ingredient;

public interface IngredientDao {
	List<Ingredient> getAll();
	
	Ingredient getByNaturalId(String nom);
	
	void persist(Ingredient ingredient);
}
