package dao;

import java.util.List;

import model.Recette;
import dto.RecetteDto;

public interface RecetteDao {
	List<Recette> getAll();
	
	RecetteDto getById(Long id);
	
	Recette getByNaturalId(String nom);
	
	void persist(RecetteDto recetteDto);
	
	void persist(Recette recette);
	
	void remove(Long id);
	
	void update(Recette recette);
	
//	Map<String, BigDecimal> getIngredients(Long recetteId);
}
