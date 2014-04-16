package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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

	@Column(name = "CATEGORIE")
	private String categorie;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "DIFFICULTE")
	private int difficulte;

	@Column(name = "AVIS")
	private int avis;

	// Assoc.
	@JsonIgnore
	@OneToMany(mappedBy = "pk.recette")
	private List<RecetteIngredient> ingredients = new ArrayList<RecetteIngredient>();

	public Recette() {
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

	@Override
	public String toString() {
		return "Recette [id=" + id + ", nom=" + nom + "]";
	}

	public List<RecetteIngredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<RecetteIngredient> ingredients) {
		this.ingredients = ingredients;
	}
}
