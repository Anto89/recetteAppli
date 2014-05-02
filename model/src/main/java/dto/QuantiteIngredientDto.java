package dto;

import java.math.BigDecimal;

import model.Ingredient;

public class QuantiteIngredientDto {
	private Ingredient ingredient;
	private BigDecimal quantite;

	public QuantiteIngredientDto() {
	}

	public QuantiteIngredientDto(Ingredient ingredient, BigDecimal quantite) {
		this.ingredient = ingredient;
		this.quantite = quantite;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public BigDecimal getQuantite() {
		return quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}
}
