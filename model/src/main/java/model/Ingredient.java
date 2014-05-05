package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
@Entity
@Table(name = "INGREDIENT")
public class Ingredient implements Serializable {
	private static final long serialVersionUID = 6218087596327098011L;

	@Id
	@SequenceGenerator(name = "ingredient_seq_gen", sequenceName = "INGREDIENT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_seq_gen")
	@Column(name = "INGREDIENT_ID")
	private Long id;

	@NaturalId
	@Column(name = "NOM")
	private String nom;

	// Assoc.
	@OneToMany(mappedBy = "pk.ingredient", fetch = FetchType.LAZY)
	private List<RecetteIngredient> recettes = new ArrayList<RecetteIngredient>();

	public Ingredient() {
	}

	public Ingredient(String nom) {
		this.nom = nom;
	}

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

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", nom=" + nom + "]";
	}

	@JsonIgnore
	public List<RecetteIngredient> getRecettes() {
		return recettes;
	}

	public void setRecettes(List<RecetteIngredient> recettes) {
		this.recettes = recettes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
}
