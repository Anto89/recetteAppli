package dao;

import model.Ingredient;

public interface IngredientDao {
	Ingredient getByNaturalId(String nom);
	
	void persist(Ingredient ingredient);
}
