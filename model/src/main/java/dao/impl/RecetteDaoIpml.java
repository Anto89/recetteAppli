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
}
