package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Recette;
import model.RecetteIngredient;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.RecetteDao;
import dto.RecetteDto;

@Repository
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
	public RecetteDto getById(Long id) {
		RecetteDto recetteDto = new RecetteDto();
		Recette recette = em.find(Recette.class, id);
		BeanUtils.copyProperties(recette, recetteDto);
		for (RecetteIngredient recIngt : recette.getQuantiteIngredient()) {
			recetteDto.addQuantiteIngredients(recIngt.getPk().getIngredient().getNom(), recIngt.getQuantite());
		}
		return recetteDto;
	}

	@Override
	public Recette getByNaturalId(String nom) {
		return (Recette) em.createQuery("from Recette i where i.nom = :nom").setParameter("nom", nom).getSingleResult();
	}

	@Override
	public void persist(RecetteDto recetteDto) {
		Recette recette = new Recette();
		BeanUtils.copyProperties(recetteDto, recette);
		em.persist(recette);
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

	// @Override
	// public Map<String, BigDecimal> getIngredients(Long recetteId) {
	// Recette recette = getById(recetteId);
	// Map<String, BigDecimal> qteIngredient = new HashMap<>();
	// for (RecetteIngredient recIngt : recette.getQuantiteIngredient()) {
	// qteIngredient.put(recIngt.getPk().getIngredient().getNom(),
	// recIngt.getQuantite());
	// }
	// return qteIngredient;
	// }
}
