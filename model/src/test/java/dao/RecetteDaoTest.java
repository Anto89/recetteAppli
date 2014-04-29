package dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Ingredient;
import model.Recette;
import model.Recette.RecetteBuilder;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

@ContextConfiguration(value = "classpath:appContext.xml")
@RunWith(value = SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "tm", defaultRollback = false)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RecetteDaoTest {

	@Autowired
	RecetteDao recDao;
	@Autowired
	IngredientDao ingDao;
	@PersistenceContext
	EntityManager em;

	Map<String, Object> data = null;

	private RecetteBuilder buildRecetteFromFile(String name) throws IOException, URISyntaxException {
		byte[] jsonData = Files.readAllBytes(Paths.get(Thread.currentThread().getContextClassLoader().getResource(name).toURI()));
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(jsonData, RecetteBuilder.class);
	}

	@Test
	public void testGetAll() throws IOException, URISyntaxException {
		Recette recette = buildRecetteFromFile("recettes/crepe.json").build();
		recDao.persist(recette);
		em.flush();
		em.clear();

		List<Recette> all = recDao.getAll();
		Assert.assertTrue(all.size() == 1);
	}

	@Test
	public void testPersist() throws IOException, URISyntaxException {
		Ingredient choco = new Ingredient("choco");
		Ingredient farine = new Ingredient("farine");
		Ingredient beurre = new Ingredient("beurre");
		ingDao.persist(choco);
		ingDao.persist(farine);
		ingDao.persist(beurre);

		Recette recette = buildRecetteFromFile("recettes/moelleux_choco.json").quantiteIngredients(choco, new BigDecimal(200))
				.quantiteIngredients(farine, new BigDecimal(200)).quantiteIngredients(beurre, new BigDecimal(200)).build();
		recDao.persist(recette);
		em.flush();
		em.clear();

		Recette founded = recDao.getByNaturalId(recette.getNom());
		Assert.assertTrue(founded.getNom().equals(recette.getNom()));
		Assert.assertTrue(founded.getQuantiteIngredient().size() == 3);
	}
}
