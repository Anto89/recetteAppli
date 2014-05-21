package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Ingredient;
import model.Recette;
import model.RecetteIngredient;

import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.IngredientDao;
import dao.RecetteDao;
import dto.QuantiteIngredientDto;
import dto.RecetteDto;

@Repository
@Transactional
public class RecetteDaoIpml implements RecetteDao {

	@PersistenceContext
	EntityManager em;
	@Autowired
	IngredientDao ingredientDao;

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
		List<RecetteIngredient> quantiteIngredient = recette.getQteIngredient();
		for (RecetteIngredient recIngt : quantiteIngredient) {
			Hibernate.initialize(recIngt.getPk().getIngredient());
			recetteDto.addQuantiteIngredients(recIngt.getPk().getIngredient(), recIngt.getQuantite());
		}
		return recetteDto;
	}

	@Override
	public Recette getByNaturalId(String nom) {
		return (Recette) em.createQuery("from Recette r where r.nom = :nom").setParameter("nom", nom).getSingleResult();
	}

	@Override
	public void save(RecetteDto recetteDto) {
		Recette recette = new Recette();
		BeanUtils.copyProperties(recetteDto, recette);
		for (QuantiteIngredientDto qteIngDto : recetteDto.getQuantiteIngredients()) {
			recette.addIngredient(mergeOrPersistIngredient(qteIngDto.getIngredient()), qteIngDto.getQuantite());
		}
		em.persist(recette);
	}

	public void update(RecetteDto recetteDto) {
		Recette recette = new Recette();
		BeanUtils.copyProperties(recetteDto, recette);

		// Mise à jour de l'association avec les ingrédients + Ajout de
		// l'ingrédient si pas déjà existant.
		List<QuantiteIngredientDto> qteIngdts = recetteDto.getQuantiteIngredients();
		for (QuantiteIngredientDto qteIngdtDto : qteIngdts) {
			recette.addIngredient(mergeOrPersistIngredient(qteIngdtDto.getIngredient()), qteIngdtDto.getQuantite());
		}

		em.merge(recette);
	}

	private Ingredient mergeOrPersistIngredient(Ingredient ingdt) {
		Ingredient existingIngdt = ingredientDao.getByNaturalId(ingdt.getNom());
		if (existingIngdt == null) {
			em.persist(ingdt);
			return ingdt; 
		}
		return existingIngdt;
	}

	@Override
	public void remove(Long id) {
		em.remove(em.find(Recette.class, id));
	}
}
