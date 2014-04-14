package dao;

import java.util.List;

import model.Recette;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RecetteDaoTest {

	private static ApplicationContext context;

	@BeforeClass
	public static void loadAppContext() {
		context = new ClassPathXmlApplicationContext("classpath:appContext.xml");
	}

	@Test
	public void testGetAll() {
		RecetteDao recetteDao = (RecetteDao) context.getBean("recetteDao");

		List<Recette> all = recetteDao.getAll();
		Assert.assertTrue(all.size() == 1);
	}
}
