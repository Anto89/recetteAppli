package dao.impl;

import java.util.List;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Ingredient> getAll() {
		return em.createQuery("from Ingredient").getResultList();
	}

	@Override
	public Ingredient getByNaturalId(String nom) {
		@SuppressWarnings("unchecked")
		List<Object> results = em.createQuery("from Ingredient i where i.nom = :nom").setParameter("nom", nom).getResultList();
		return results.size() == 0 ? null : (Ingredient) results.get(0);
	}

	@Override
	public void persist(Ingredient ingredient) {
		em.persist(ingredient);
	}
}
