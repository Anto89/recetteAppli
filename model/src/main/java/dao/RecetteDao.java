package dao;

import java.util.List;

import model.Recette;
import dto.RecetteDto;

public interface RecetteDao {
	List<Recette> getAll();

	RecetteDto getById(Long id);

	Recette getByNaturalId(String nom);

	void save(RecetteDto recetteDto);

	void update(RecetteDto recetteDto);

	void remove(Long id);
}
