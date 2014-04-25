package dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import model.Recette;

import org.springframework.stereotype.Repository;

@Repository
public interface RecetteDao {
	List<Recette> getAll();
	
	Recette getById(Long id);
	
	void persist(Recette recette);
	
	void remove(Long id);
	
	void update(Recette recette);
	
	Map<String, BigDecimal> getIngredients(Long recetteId);
}
