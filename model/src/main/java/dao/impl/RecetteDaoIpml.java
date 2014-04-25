package dao.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Recette;
import model.RecetteIngredient;

import org.springframework.transaction.annotation.Transactional;

import dao.RecetteDao;

@Transactional
public class RecetteDaoIpml implements RecetteDao {

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Recette> getAll() {
		return em.createQuery("from Recette").getResultList();
	}

	@Override
	public Recette getById(Long id) {
		return em.find(Recette.class, id);
	}

	@Override
	public void persist(Recette recette) {
		em.persist(recette);
	}

	@Override
	public void remove(Long id) {
		em.remove(getById(id));
	}

	@Override
	public void update(Recette recette) {
		em.merge(recette);
	}

	@Override
	public Map<String, BigDecimal> getIngredients(Long recetteId) {
		Recette recette = getById(recetteId);
		Map<String, BigDecimal> qteIngredient = new HashMap<>();
		for (RecetteIngredient recIngt : recette.getQuantiteIngredient()) {
			qteIngredient.put(recIngt.getPk().getIngredient().getNom(), recIngt.getQuantite());
		}
		return qteIngredient;
	}
}
