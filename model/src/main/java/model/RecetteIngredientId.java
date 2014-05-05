package model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
public class RecetteIngredientId implements Serializable {
	private static final long serialVersionUID = -5759128945118040522L;
	@ManyToOne(fetch = FetchType.LAZY)
	private Recette recette;
	@ManyToOne(fetch = FetchType.LAZY)
	private Ingredient ingredient;

	public RecetteIngredientId() {
	}

	public RecetteIngredientId(Recette recette, Ingredient ingredient) {
		this.recette = recette;
		this.ingredient = ingredient;
	}

	public Recette getRecette() {
		return recette;
	}

	public void setRecette(Recette recette) {
		this.recette = recette;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
		result = prime * result + ((recette == null) ? 0 : recette.hashCode());
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
		RecetteIngredientId other = (RecetteIngredientId) obj;
		if (ingredient == null) {
			if (other.ingredient != null)
				return false;
		} else if (!ingredient.equals(other.ingredient))
			return false;
		if (recette == null) {
			if (other.recette != null)
				return false;
		} else if (!recette.equals(other.recette))
			return false;
		return true;
	}
}
