package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RECETTE")
public class Recette implements Serializable {
	private static final long serialVersionUID = 1293602953091879759L;

	@Id
	@SequenceGenerator(name = "recette_seq_gen", sequenceName = "RECETTE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recette_seq_gen")
	@Column(name = "RECETTE_ID")
	private Long id;

	@NaturalId
	@Column(name = "NOM")
	private String nom;

	@Column(name = "IMAGE")
	private byte[] imageFile;

	@Transient
	private String imagePath;

	@Column(name = "CATEGORIE")
	private String categorie;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "DIFFICULTE")
	private int difficulte;

	@Column(name = "AVIS")
	private int avis;

	@Column(name = "IS_VEGETARIEN")
	private boolean vegetarien;

	// Assoc.
	@OneToMany(mappedBy = "pk.recette", cascade = CascadeType.ALL)
	private List<RecetteIngredient> ingredients = new ArrayList<RecetteIngredient>();

	public Recette() {
		this.imagePath = "/image/recette.png";
	}

	public Recette(RecetteBuilder builder) {
		this.nom = builder.nom;
		this.imagePath = "/image/recette.png";
		this.categorie = builder.categorie;
		this.description = builder.description;
		this.difficulte = builder.difficulte;
		this.avis = builder.avis;
		this.vegetarien = builder.vegetarien;

		for (Entry<Ingredient, BigDecimal> entry : builder.quantiteIngredients.entrySet()) {
			this.addIngredient(entry.getKey(), entry.getValue());
		}
	}

	public Recette(String nom) {
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	@JsonIgnore
	public List<RecetteIngredient> getQuantiteIngredient() {
		return ingredients;
	}

	@JsonIgnore
	public List<Ingredient> getIngredients() {
		List<Ingredient> ingdts = new ArrayList<>(ingredients.size());
		for (RecetteIngredient recIng : ingredients) {
			ingdts.add(recIng.getPk().getIngredient());
		}
		return ingdts;
	}

	public void setIngredients(List<RecetteIngredient> ingredients) {
		this.ingredients = ingredients;
	}

	public void addIngredient(Ingredient ingredient, BigDecimal quantite) {
		this.ingredients.add(new RecetteIngredient(new RecetteIngredientId(this, ingredient), quantite));
	}

	public byte[] getImageFile() {
		return imageFile;
	}

	public void setImageFile(byte[] image) {
		this.imageFile = image;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public boolean isVegetarien() {
		return vegetarien;
	}

	public void setVegetarien(boolean vegetarien) {
		this.vegetarien = vegetarien;
	}

	@Override
	public String toString() {
		return "Recette [id=" + id + ", nom=" + nom + "]";
	}

	@JsonAutoDetect(fieldVisibility = Visibility.ANY)
	public static class RecetteBuilder {
		private String nom;
		private String categorie;
		private String description;
		private int difficulte;
		private int avis;
		private boolean vegetarien;

		private Map<Ingredient, BigDecimal> quantiteIngredients = new HashMap<>();

		public RecetteBuilder() {
		}

		public RecetteBuilder(String nom) {
			this.nom = nom;
		}

		public RecetteBuilder categorie(String categorie) {
			this.categorie = categorie;
			return this;
		}

		public RecetteBuilder description(String description) {
			this.description = description;
			return this;
		}

		public RecetteBuilder difficulte(int difficulte) {
			this.difficulte = difficulte;
			return this;
		}

		public RecetteBuilder avis(int avis) {
			this.avis = avis;
			return this;
		}

		public RecetteBuilder vegetarien(boolean vegetarien) {
			this.vegetarien = vegetarien;
			return this;
		}

		public RecetteBuilder quantiteIngredients(Ingredient ingredient, BigDecimal quantite) {
			this.quantiteIngredients.put(ingredient, quantite);
			return this;
		}

		public Recette build() {
			return new Recette(this);
		}
	}
}
