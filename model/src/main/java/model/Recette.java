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
@Table(name = "RECETTE")
public class Recette implements Serializable {
	private static final long serialVersionUID = 1293602953091879759L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="recette_seq_gen")
	@SequenceGenerator(name="recette_seq_gen", sequenceName="RECETTE_SEQ")
	@Column(name="RECETTE_ID")
	private Long id;
	@Column(name="NOM")
	private String name;
	
	// Assoc.
	@OneToMany(mappedBy="pk.recette")
	private List<RecetteIngredient> ingredients = new ArrayList<RecetteIngredient>();

	public Recette() {
	}
	
	public Recette(String name) {
		this.name = name;
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
		return "Recette [id=" + id + ", name=" + name + "]";
	}

	public List<RecetteIngredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<RecetteIngredient> ingredients) {
		this.ingredients = ingredients;
	}
}
