package dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import model.Ingredient;

public class RecetteDto {

	private Long id;
	private String nom;
	private String imagePath;
	private String categorie;
	private String description;
	private int difficulte;
	private int avis;
	private boolean vegetarien;
	private List<QuantiteIngredientDto> quantiteIngredients = new ArrayList<>();

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

	public List<QuantiteIngredientDto> getQuantiteIngredients() {
		return quantiteIngredients;
	}

	public void addQuantiteIngredients(Ingredient ingredient, BigDecimal quantite) {
		this.quantiteIngredients.add(new QuantiteIngredientDto(ingredient, quantite));
	}

	public void setQuantiteIngredients(List<QuantiteIngredientDto> quantiteIngredients) {
		this.quantiteIngredients = quantiteIngredients;
	}
}
