package model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "RECETTE_INGREDIENT")
@AssociationOverrides({
		@AssociationOverride(name = "pk.recette", joinColumns = @JoinColumn(name = "RECETTE_ID")),
		@AssociationOverride(name = "pk.ingredient", joinColumns = @JoinColumn(name = "INGREDIENT_ID")) })
public class RecetteIngredient implements Serializable {
	private static final long serialVersionUID = 1293602953091879759L;

	@EmbeddedId
	private RecetteIngredientId pk;
	private BigDecimal quantite;

	public RecetteIngredient() {
	}

	public BigDecimal getQuantite() {
		return quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public RecetteIngredientId getPk() {
		return pk;
	}

	public void setPk(RecetteIngredientId pk) {
		this.pk = pk;
	}
}
