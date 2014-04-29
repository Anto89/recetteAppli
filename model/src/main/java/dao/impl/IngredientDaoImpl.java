package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Ingredient;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.IngredientDao;

@Repository
@Transactional
public class IngredientDaoImpl implements IngredientDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public Ingredient getByNaturalId(String nom) {
		return (Ingredient) em.createQuery("from Ingredient i where i.nom = :nom");
	}

	@Override
	public void persist(Ingredient ingredient) {
		em.persist(ingredient);
	}

}
