package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Recette;

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
}
