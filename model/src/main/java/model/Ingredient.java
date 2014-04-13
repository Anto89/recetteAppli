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

@Entity
@Table(name = "INGREDIENT")
public class Ingredient implements Serializable {
	private static final long serialVersionUID = 6218087596327098011L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ingredient_seq_gen")
	@SequenceGenerator(name = "ingredient_seq_gen", sequenceName = "INGREDIENT_SEQ")
	@Column(name="INGREDIENT_ID")
	private Long id;
	
	@Column(name="NOM")
	private String name;
	
	// Assoc.
	@OneToMany(mappedBy="pk.ingredient")
	private List<RecetteIngredient> recettes = new ArrayList<RecetteIngredient>();

	public Ingredient() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + "]";
	}

	public List<RecetteIngredient> getRecettes() {
		return recettes;
	}

	public void setRecettes(List<RecetteIngredient> recettes) {
		this.recettes = recettes;
	}
}
