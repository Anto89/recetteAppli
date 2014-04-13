package dao;

import java.util.List;

import model.Recette;

import org.springframework.stereotype.Repository;

@Repository
public interface RecetteDao {
	List<Recette> getAll();
}
