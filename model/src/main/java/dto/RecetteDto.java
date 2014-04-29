package dto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class RecetteDto {

	private Long id;
	private String nom;
	private String imagePath;
	private String categorie;
	private String description;
	private int difficulte;
	private int avis;
	private boolean vegetarien;
	private Map<String, BigDecimal> quantiteIngredients = new HashMap<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(int difficulte) {
		this.difficulte = difficulte;
	}

	public int getAvis() {
		return avis;
	}

	public void setAvis(int avis) {
		this.avis = avis;
	}

	public boolean isVegetarien() {
		return vegetarien;
	}

	public void setVegetarien(boolean vegetarien) {
		this.vegetarien = vegetarien;
	}

	public Map<String, BigDecimal> getQuantiteIngredients() {
		return quantiteIngredients;
	}

	public void addQuantiteIngredients(String ingredient, BigDecimal quantite) {
		this.quantiteIngredients.put(ingredient, quantite);
	}
}
