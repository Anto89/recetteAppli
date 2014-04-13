
import java.util.List;

import model.Recette;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.RecetteDao;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:appContext.xml");
		
		
		// PersonDao dao = (PersonDao) context.getBean("personDao");
		// Person peter = new Person("Peter", "Sagan");
		// Person nasta = new Person("Nasta", "Kuzminova");
		// dao.save(peter);
		// dao.save(nasta);
		// List<Person> persons = dao.getAll();
		// for (Person person : persons) {
		// System.out.println(person);
		// }
		
		RecetteDao recettedao = (RecetteDao) context.getBean("recetteDao");
		List<Recette> recettes = recettedao.getAll();
		for (Recette recette : recettes) {
			System.out.println(recette);
		}
		
		context.close();
	}
}
